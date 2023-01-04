package com.project.apiperson.service;

import com.project.apiperson.domain.dto.PersonPut;
import com.project.apiperson.domain.entities.Address;
import com.project.apiperson.domain.entities.City;
import com.project.apiperson.domain.entities.Person;
import com.project.apiperson.domain.dto.PersonAll;
import com.project.apiperson.domain.dto.PersonDto;
import com.project.apiperson.domain.dto.PersonPost;
import com.project.apiperson.repository.AddressRepository;
import com.project.apiperson.repository.PersonRepository;
import com.project.apiperson.service.exceptions.DataIntegrityViolationException;
import com.project.apiperson.service.exceptions.ObjectNotFoundException;
import com.project.apiperson.service.exceptions.CustomExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    private final AddressRepository addressRepository;

    public PersonService(PersonRepository personRepository, AddressRepository addressRepository) {
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
    }

    public Person findPersonByID(Integer id){
        return personRepository.findById(id)
                .orElseThrow( () -> new ObjectNotFoundException("Error: Entity not found.") );
    }

    public List<PersonAll> findAllPerson(){
        List<PersonAll> listPerson = personRepository.findAll().stream().map( obj -> new PersonAll(obj)).collect(Collectors.toList());
        if(listPerson.isEmpty()){
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
        personRepository.save(person);
        return person;
    }


    private void update(Person p1, PersonPut p2){
        p1.setName(p2.getName());
        p1.setEmail(p2.getEmail());
    }

    public void findEmail(PersonPost person){
        Optional<Person> findEmail = personRepository.findByEmail(person.getEmail());
        if(findEmail.isPresent()){
            throw new DataIntegrityViolationException("Error: email is already being used.");
        }
    }

    public Person fromDto(PersonPost person){
        Person personAtt = new Person();
        City city = new City(person.getCityId(), null);
        Address address = new Address(null, person.getStreet(), person.getZipCode(), person.getNumber(), personAtt, city);
        personAtt.setId(null)
                .setName(person.getName())
                .setEmail(person.getEmail())
                .setCpf(person.getCpf())
                .setDateOfBirth(person.getDateOfBirth())
                .getAddresses().add(address);
        return personAtt;
    }

}

