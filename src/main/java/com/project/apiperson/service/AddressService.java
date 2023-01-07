package com.project.apiperson.service;
import com.project.apiperson.domain.dto.AddressAll;
import com.project.apiperson.domain.dto.AddressPost;
import com.project.apiperson.domain.dto.PersonAll;
import com.project.apiperson.domain.entities.Address;
import com.project.apiperson.domain.entities.City;
import com.project.apiperson.domain.entities.Person;
import com.project.apiperson.repository.AddressRepository;
import com.project.apiperson.repository.PersonRepository;
import com.project.apiperson.service.exceptions.CustomExceptions;
import com.project.apiperson.service.exceptions.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {

    public static final char NON_PRIORITY_ADDRESS = 'N';
    public static final char PRIORITY_ADDRESS = 'Y';
    private final Logger logger = LoggerFactory.getLogger(AddressService.class);

    private final AddressRepository addressRepository;

    private final PersonService personService;

    private final CityService cityService;

    public AddressService(AddressRepository addressRepository, PersonService personService, CityService cityService, PersonRepository personRepository) {
        this.addressRepository = addressRepository;
        this.personService = personService;
        this.cityService = cityService;
    }

    public Address findAddressById(Integer id){
        logger.info("m=findAddressById stage=init id={}", id);
        return addressRepository.findById(id).orElseThrow( () -> {
            logger.error("m=findAddressById stage=error id={}", id);
            return new ObjectNotFoundException("Error: Entity not found.");
        });
    }

    public List<AddressAll> findAllAddresses(){
        logger.info("m=findAllAddresses stage=init");
        List<AddressAll> listAddress = addressRepository.findAll()
                .stream()
                .map(AddressAll::new)
                .collect(Collectors.toList());
        if(listAddress.isEmpty()){
            logger.error("m=findAllAddresses stage=error listAddress={}", listAddress);
            throw new CustomExceptions("Error: no person found.");
        }
        logger.info("m=findAllAddresses stage=finish persons={}", listAddress);
        return listAddress;
    }

    public Address insertAddressForPerson(AddressPost addressPost) {
        logger.info("m=insertAddressForPerson stage=init addressPost={}", addressPost);
        Address address = fromDto(addressPost);
        addressRepository.save(address);
        logger.info("m=insertAddressForPerson stage=finish");
        return address;
    }

    private Address fromDto(AddressPost addressPost) {
        Address address = new Address(null, addressPost.getStreet(), addressPost.getZipcode(), addressPost.getNumber(), addressPost.getPriotiryAddress(), null, null);
        Person person = personService.findPersonByID(addressPost.getPersonId());
        City city = cityService.findCityByID(addressPost.getCityId());
        verifyPriority(addressPost);
        findPriorityAddress(person, addressPost);
        address.setCity(city);
        address.setPerson(person);
        return address;
    }

    private List<AddressAll> findAllAddress() {
        return addressRepository.findAll()
                .stream()
                .map(AddressAll::new)
                .collect(Collectors.toList());
    }

    private void findPriorityAddress(Person personEntity, AddressPost addressPost) {
        if(isNonPriorityAddress(addressPost)) return;
        personEntity.getAddresses().forEach((address -> {
            if (isPriorityAddress(address)) {
                logger.error("m=changePerson stage=error personEntity={} addressPost={}", personEntity.getName(), addressPost.getPriotiryAddress());
                throw new CustomExceptions("This person already has an address as a priority, please change the person's reference or priority status");
            }
        }));
    }

    private static boolean isPriorityAddress(Address address) {
        return address.getPriorityAddress() == PRIORITY_ADDRESS;
    }

    private static boolean isNonPriorityAddress(AddressPost address) {
        return address.getPriotiryAddress() == NON_PRIORITY_ADDRESS;
    }

    private void verifyPriority(AddressPost addressPost) {
        if(isValidPriority(addressPost)){
            logger.error("m=changePerson stage=error personPut={}", addressPost);
            throw new CustomExceptions("Error: use Y for true and N for false.");
        }
    }

    private static boolean isValidPriority(AddressPost addressPost) {
        return addressPost.getPriotiryAddress() != 'Y' && addressPost.getPriotiryAddress() != 'N';
    }


}
