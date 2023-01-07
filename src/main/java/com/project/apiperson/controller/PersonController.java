package com.project.apiperson.controller;

import com.project.apiperson.domain.dto.PersonAll;
import com.project.apiperson.domain.dto.PersonDto;
import com.project.apiperson.domain.dto.PersonPost;
import com.project.apiperson.domain.dto.PersonPut;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Person", description = "Manage person data")
@RequestMapping(value = "/api/v1/persons")
public interface PersonController {

    @Operation(description = "Find person")
    @GetMapping(value = "/{id}")
    ResponseEntity<PersonDto> findPerson(@PathVariable Integer id);

    @Operation(description = "Find all persons")
    @GetMapping
    ResponseEntity<List<PersonAll>> findListPersons();

    @Operation(description = "Change person")
    @PutMapping(value = "/{id}")
    ResponseEntity<Void> updatePerson(@PathVariable Integer id,@Valid @RequestBody PersonPut person);

    @Operation(description = "Inserting person")
    @PostMapping
    ResponseEntity<Void> insertPerson(@Valid @RequestBody PersonPost personPost);

    @GetMapping("/confirmAccount")
    String confirmAccount(@RequestParam String confirmationToken);
}
