package com.project.apiperson.controller.impl;

import com.project.apiperson.controller.PersonController;
import com.project.apiperson.domain.dto.PersonAll;
import com.project.apiperson.domain.dto.PersonDto;
import com.project.apiperson.domain.dto.PersonPost;
import com.project.apiperson.domain.dto.PersonPut;
import com.project.apiperson.domain.entities.Person;
import com.project.apiperson.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class PersonControllerImpl implements PersonController {

    private final Logger logger = LoggerFactory.getLogger(PersonControllerImpl.class);
    private final PersonService personService;

    public PersonControllerImpl(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public ResponseEntity<PersonDto> findPerson(Integer id){
        logger.info("m=findPerson stage=init id={}", id);
        Person person = personService.findPersonByID(id);
        var newPerson = new PersonDto(person);
        logger.info("m=findPerson stage=finish newPerson={}", newPerson);
        return ResponseEntity.ok(newPerson);
    }

    @Override
    public ResponseEntity<List<PersonAll>> findListPersons(){
        logger.info("m=findListPersons stage=init");
        List<PersonAll> listPersons = personService.findAllPerson();
        logger.info("m=findListPersons stage=finish listPersons={}", listPersons);
        return ResponseEntity.ok(listPersons);
    }

    @Override
    public ResponseEntity<Void> updatePerson(Integer id, PersonPut person){
        logger.info("m=updatePerson stage=init id={}, person={}", id, person);
        PersonPut newPersonUpdate = personService.changePerson(id, person);
        logger.info("m=updatePerson stage=finish newUpdatePerson={}", newPersonUpdate);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> insertPerson(PersonPost personPost) {
        logger.info("m=insertPerson stage=init personPost={}", personPost);
        var id = personService.insertPerson(personPost).getId();
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        logger.info("m=insertPerson stage=finish uri={}", uri);
        return ResponseEntity.created(uri).build();
    }

    @Override
    public String confirmAccount(String confirmationToken){
        logger.info("m=confirmAccount stage=init {}",confirmationToken);
        var result = personService.confirmAccount(confirmationToken);
        logger.info("m=confirmAccount stage=finish");
        return result;
    }

}
