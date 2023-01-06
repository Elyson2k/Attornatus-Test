package com.project.apiperson.service;

import com.project.apiperson.controller.AddressController;
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

import javax.mail.MessagingException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final Logger logger = LoggerFactory.getLogger(AddressController.class);
    private final PersonRepository personRepository;

    private final AddressRepository addressRepository;


    public PersonService(PersonRepository personRepository, AddressRepository addressRepository) {
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
    }

    public Person findPersonByID(Integer id){
        Optional<Person> person = personRepository.findById(id);
        if(!(person.isPresent())){
            logger.error("m=findPersonByID stage=error id={}", id);
            throw new ObjectNotFoundException("Error: Entity not found.");
        } else return person.get();
    }

    public List<PersonAll> findAllPerson(){
        List<PersonAll> listPerson = personRepository.findAll().stream().map( obj -> new PersonAll(obj)).collect(Collectors.toList());
        if(listPerson.isEmpty()){
            logger.error("m=findAllPerson stage=error listPerson={}", listPerson);
            throw new CustomExceptions("Error: no person found.");
        } else return listPerson;
    }

    public Person insertPerson(PersonPost person){
        findEmail(person);
        Person personEntity = fromDto(person);
        personRepository.save(personEntity);
        addressRepository.saveAll(personEntity.getAddresses());
        return personEntity;
    }

    public Person chancePerson(PersonPut updatePerson){
        Person person = findPersonByID(updatePerson.getId());
        update(person, updatePerson);
        verifyPriority(updatePerson);
        personRepository.save(person);
        return person;
    }


    private void update(Person p1, PersonPut p2){
        p1.setName(p2.getName());
        p1.setEmail(p2.getEmail());
        findPriorityAddress(p1,p2);
        p1.getAddresses().get( (p2.getAddressId() -1 )).setPriorityAddress(p2.getPriorityAddress());
    }

    public void findEmail(PersonPost person){
        Optional<Person> findEmail = personRepository.findByEmail(person.getEmail());
        if(findEmail.isPresent()){
            logger.error("m=findEmail stage=error findEmail={}", findEmail.get().getEmail());
            throw new DataIntegrityViolationException("Error: email is already being used.");
        }
    }

    public Person fromDto(PersonPost person){
        Person personAtt = new Person();
        City city = new City(person.getCityId(), null);
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
                logger.error("m=changePerson stage=error personEntity={} personPut={}", personEntity.getName(), person.getName());
                throw new CustomExceptions("This person already has an address as a priority, please change the person's reference or priority status");
            }
            return;
        }
    }

    private void verifyPriority(PersonPut updatePerson) {
        if(updatePerson.getPriorityAddress() != 'Y' && updatePerson.getPriorityAddress() != 'N'){
            logger.error("m=changePerson stage=error personPut={}", updatePerson);
            throw new CustomExceptions("Error: use Y for true and N for false.");
        }
    }

}

