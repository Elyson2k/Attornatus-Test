package com.project.apiperson.controller;

import com.project.apiperson.entities.Address;
import com.project.apiperson.entities.dto.AddressAll;
import com.project.apiperson.entities.dto.AddressDto;
import com.project.apiperson.entities.dto.AddressPost;
import com.project.apiperson.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/addresses")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AddressDto> findAddress(@PathVariable Integer id){
        Address person = addressService.findAddressByID(id);
        return ResponseEntity.ok(new AddressDto(person));
    }

    @GetMapping
    public ResponseEntity<List<AddressAll>> findAllPersons(){
        List<AddressAll> listAddress = addressService.listAddress();
        return ResponseEntity.ok(listAddress);
    }

    @PostMapping
    public ResponseEntity<AddressPost> insertAddressForPerson(@RequestBody AddressPost addressPost){
        var id = addressService.insertAddressForPerson(addressPost).getId();
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }
}
