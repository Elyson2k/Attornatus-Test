package com.project.apiperson.controller;

import com.project.apiperson.domain.dto.PersonPut;
import com.project.apiperson.domain.entities.Person;
import com.project.apiperson.domain.dto.PersonAll;
import com.project.apiperson.domain.dto.PersonDto;
import com.project.apiperson.domain.dto.PersonPost;
import com.project.apiperson.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/persons")
public class PersonController {

    private final Logger logger = LoggerFactory.getLogger(AddressController.class);
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PersonDto> findPerson(@PathVariable Integer id){
        logger.info("m=findPerson stage=init id={}", id);
        Person person = personService.findPersonByID(id);
        var newPerson = new PersonDto(person);
        logger.info("m=findPerson stage=finish newPerson={}", newPerson);
        return ResponseEntity.ok(newPerson);
    }

    @GetMapping
    public ResponseEntity<List<PersonAll>> findListPersons(){
        logger.info("m=findListPersons stage=init");
        List<PersonAll> listPersons = personService.findAllPerson();
        logger.info("m=findListPersons stage=finish listPersons={}", listPersons);
        return ResponseEntity.ok(listPersons);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> updatePerson(@PathVariable Integer id,@Valid @RequestBody PersonPut person){
        logger.info("m=updatePerson stage=init id={}, person={}", id, person);
        person.setId(id);
        var newPerson = personService.chancePerson(person);
        var newPersonUpdate = new PersonPut(newPerson);
        logger.info("m=updatePerson stage=finish newUpdatePerson={}", newPersonUpdate);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Void> insertPerson(@Valid @RequestBody PersonPost personPost){
        logger.info("m=insertPerson stage=init personPost={}", personPost);
        var id = personService.insertPerson(personPost).getId();
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        logger.info("m=insertPerson stage=finish uri={}", uri);
        return ResponseEntity.created(uri).build();
    }

}
