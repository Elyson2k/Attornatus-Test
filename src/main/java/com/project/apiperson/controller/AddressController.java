package com.project.apiperson.controller;

import com.project.apiperson.domain.entities.Address;
import com.project.apiperson.domain.dto.AddressAll;
import com.project.apiperson.domain.dto.AddressDto;
import com.project.apiperson.domain.dto.AddressPost;
import com.project.apiperson.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

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
        List<AddressAll> listAddress = addressService.findAllAddresses();
        return ResponseEntity.ok(listAddress);
    }

    @PostMapping
    public ResponseEntity<Void> insertAddressForPerson(@RequestBody AddressPost addressPost){
        var id = addressService.insertAddressForPerson(addressPost).getId();
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }
}
