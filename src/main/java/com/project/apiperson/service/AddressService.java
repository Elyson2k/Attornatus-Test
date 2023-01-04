package com.project.apiperson.service;

import com.project.apiperson.domain.entities.Address;
import com.project.apiperson.domain.entities.City;
import com.project.apiperson.domain.entities.Person;
import com.project.apiperson.domain.dto.AddressAll;
import com.project.apiperson.domain.dto.AddressPost;
import com.project.apiperson.repository.AddressRepository;
import com.project.apiperson.repository.PersonRepository;
import com.project.apiperson.service.exceptions.CustomExceptions;
import com.project.apiperson.service.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final PersonService personService;
    private final CityService cityService;

    public AddressService(AddressRepository addressRepository, PersonService personService, CityService cityService, PersonRepository personRepository) {
        this.addressRepository = addressRepository;
        this.personService = personService;
        this.cityService = cityService;

    }

    public Address findAddressByID(Integer id){
        return addressRepository.findById(id)
                .orElseThrow( () -> new ObjectNotFoundException("Error: Entity not found.") );
    }

    public List<AddressAll> findAllAddresses(){
        List<AddressAll> listAddress = findAllAddress();
        if(listAddress.isEmpty()){
            throw new CustomExceptions("Error: no address found.");
        } else return listAddress;
    }

    public Address insertAddressForPerson(AddressPost addressPost){
        Address address = fromDto(addressPost);
        addressRepository.save(address);
        return address;
    }

    private Address fromDto(AddressPost addressPost){
        Person person = personService.findPersonByID(addressPost.getPersonId());
        City city = cityService.findCityByID(addressPost.getCityId());
        Address address = new Address(null, addressPost.getStreet(), addressPost.getZipCode(), addressPost.getNumber(), person, city);
        return address;
    }
    private List<AddressAll> findAllAddress() {
        return addressRepository.findAll().stream().map(obj -> new AddressAll(obj)).collect(Collectors.toList());
    }

}
