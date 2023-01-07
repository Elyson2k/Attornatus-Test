package com.project.apiperson.controller;

import com.project.apiperson.domain.dto.AddressAll;
import com.project.apiperson.domain.dto.AddressDto;
import com.project.apiperson.domain.dto.AddressPost;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Address", description = "Manage address data")
@RequestMapping(value = "/api/v1/address")
public interface AddressController {

    @Operation(description = "Find address")
    @GetMapping(value = "/{id}")
    ResponseEntity<AddressDto> findAddress(@PathVariable Integer id);

    @Operation(description = "Find all addresses")
    @GetMapping
    ResponseEntity<List<AddressAll>> findAllAddress();

    @Operation(description = "Inserting address")
    @PostMapping
    ResponseEntity<Void> insertAddressForPerson(@RequestBody AddressPost addressPost);
}