package com.project.apiperson.service;


import com.project.apiperson.domain.dto.*;
import com.project.apiperson.domain.entities.Address;
import com.project.apiperson.domain.entities.City;
import com.project.apiperson.domain.entities.Person;
import com.project.apiperson.repository.AddressRepository;
import com.project.apiperson.repository.PersonRepository;
import com.project.apiperson.service.exceptions.DataIntegrityViolationException;
import com.project.apiperson.service.exceptions.ObjectNotFoundException;
import com.project.apiperson.service.exceptions.CustomExceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PersonService {

    public static final String SUCCESS_VERIFICATION = "<h1>congratulations, your account has been verified!</h1>";
    private final Logger logger = LoggerFactory.getLogger(PersonService.class);
    private final PersonRepository personRepository;

    private final CityService cityService;
    private final AddressRepository addressRepository;

    private final EmailService emailService;

    public PersonService(PersonRepository personRepository, CityService cityService, AddressRepository addressRepository, EmailService emailService) {
        this.personRepository = personRepository;
        this.cityService = cityService;
        this.addressRepository = addressRepository;
        this.emailService = emailService;
    }

    public Person findPersonByID(Integer id){
        logger.info("m=findPersonByID stage=init id={}", id);
        return personRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("m=findPersonByID stage=error id={}", id);
                    return new ObjectNotFoundException("Error: Entity not found.");
                });
    }

    public List<PersonAll> findAllPerson(){
        logger.info("m=findAllPerson stage=init");
        List<PersonAll> listPerson = personRepository.findAll()
                .stream()
                .map(PersonAll::new)
                .collect(Collectors.toList());
        if(listPerson.isEmpty()){
            logger.error("m=findAllPerson stage=error listPerson={}", listPerson);
            throw new CustomExceptions("Error: no person found.");
        }
        logger.info("m=findAllPerson stage=finish persons={}", listPerson);
        return listPerson;
    }

    @Transactional
    public Person insertPerson(PersonPost person){
        logger.info("m=insertPerson stage=init person={}", person);
        findEmail(person);
        Person personEntity = fromDto(person)
                .setConfirmationToken(UUID.randomUUID())
                .setAccountVerified(false);
        personRepository.save(personEntity);
        addressRepository.saveAll(personEntity.getAddresses());
        emailService.sendSimpleMessage(personEntity);
        logger.info("m=changePerson stage=finish");
        return personEntity;
    }

    public String confirmAccount(String confirmationToken){
        logger.info("m=confirmAccount stage=init confirmationToken={}", confirmationToken);
        Person person = personRepository.findByConfirmationToken(UUID.fromString(confirmationToken)).orElseThrow(() -> {
            logger.error("m=changePerson stage=error confirmationToken={}", confirmationToken);
            return new CustomExceptions("Error: we can't verify your account");
        });
        person.setAccountVerified(true);
        personRepository.save(person);
        logger.info("m=confirmAccout stage=finish");
        return SUCCESS_VERIFICATION;
    }

    public PersonPut changePerson(Integer id, PersonPut person) {
        logger.info("m=changePerson stage=init id={} person={}", id, person);
        person.setId(id);
        var newPerson = updatePerson(person);
        logger.info("m=changePerson stage=finish");
        return new PersonPut(newPerson);
    }

    private Person updatePerson(PersonPut updatePerson){
        Person person = findPersonByID(updatePerson.getId());
        update(person, updatePerson);
        validatePriority(updatePerson);
        personRepository.save(person);
        return person;
    }

    private void update(Person p1, PersonPut p2){
        p1.setName(p2.getName());
        p1.setEmail(p2.getEmail());
        findPriorityAddress(p1,p2);
        if(p2.getAddressId() > p1.getAddresses().size() || p2.getAddressId() < p1.getAddresses().size()) {
            throw new CustomExceptions("Error: numbers beetwen = 1 and " + p1.getAddresses().size());
        }
        p1.getAddresses().get( (p2.getAddressId() -1 )).setPriorityAddress(p2.getPriorityAddress());
    }

    public void findEmail(PersonPost person){
        logger.info("m=findEmail stage=init email={}", person.getEmail());
        Optional<Person> findEmail = personRepository.findByEmail(person.getEmail());
        if(findEmail.isPresent()){
            logger.error("m=findEmail stage=error findEmail={}", findEmail.get().getEmail());
            throw new DataIntegrityViolationException("Error: email is already being used.");
        }
    }

    public Person fromDto(PersonPost person){
        Person personAtt = new Person();
        City city = cityService.findCityByID(person.getCityId());
        Address address = new Address(null, person.getStreet(), person.getZipCode(), person.getNumber(), person.getPriorityAddress(), personAtt, city);
        personAtt.setId(null)
                .setName(person.getName())
                .setEmail(person.getEmail())
                .setCpf(person.getCpf())
                .setDateOfBirth(person.getDateOfBirth())
                .getAddresses().add(address);
        return personAtt;
    }

    private void findPriorityAddress(Person personEntity, PersonPut person) {
        for (Address x : personEntity.getAddresses()) {
            if (x.getPriorityAddress() == 'Y' && person.getPriorityAddress() == 'Y') {
                logger.error("m=changePerson stage=error personEntity={} person={}", personEntity.getName(), person.getName());
                throw new CustomExceptions("This person already has an address as a priority, please change the person's reference or priority status");
            }
            return;
        }
    }

    private void validatePriority(PersonPut person) {
        if(isValidPriority(person)){
            logger.error("m=changePerson stage=error person={}", person);
            throw new CustomExceptions("Error: use Y for true and N for false.");
        }
    }

    private static boolean isValidPriority(PersonPut person) {
        return person.getPriorityAddress() != 'Y' && person.getPriorityAddress() != 'N';
    }

}

