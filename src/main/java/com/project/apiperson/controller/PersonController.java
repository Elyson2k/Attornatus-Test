package com.project.apiperson.controller;

import com.project.apiperson.entities.Person;
import com.project.apiperson.entities.dto.PersonAll;
import com.project.apiperson.entities.dto.PersonDto;
import com.project.apiperson.entities.dto.PersonPost;
import com.project.apiperson.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PersonDto> findPerson(@PathVariable Integer id){
        Person person = personService.findPersonByID(id);
        var newPerson = new PersonDto(person);
        return ResponseEntity.ok(newPerson);
    }

    @GetMapping
    public ResponseEntity<List<PersonAll>> findListPersons(){
        List<PersonAll> listPersons = personService.findAllPerson();
        return ResponseEntity.ok(listPersons);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> updatePerson(@PathVariable Integer id,@Valid @RequestBody PersonDto person){
        person.setId(id);
        var newPerson = personService.chancePerson(person);
        var newPersonUpdate = new Person(newPerson);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Void> insertPerson(@Valid @RequestBody PersonPost personDto){
        var id = personService.insertPerson(personDto).getId();
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }



}
