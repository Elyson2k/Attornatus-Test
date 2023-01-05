package com.project.apiperson.controller;

import com.project.apiperson.domain.entities.Address;
import com.project.apiperson.domain.dto.AddressAll;
import com.project.apiperson.domain.dto.AddressDto;
import com.project.apiperson.domain.dto.AddressPost;
import com.project.apiperson.service.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/addresses")
public class AddressController {

    private final Logger logger = LoggerFactory.getLogger(AddressController.class);

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AddressDto> findAddress(@PathVariable Integer id){
        logger.info("m=findAddress stage=init id={}", id);
        Address address = addressService.findAddressById(id);
        var newAddress = new AddressDto(address);
        logger.info("m=findAddress stage=finish newAddress={}", newAddress);
        return ResponseEntity.ok(newAddress);
    }

    @GetMapping
    public ResponseEntity<List<AddressAll>> findAllAddress(){
        logger.info("m=findAllAddress stage=init");
        List<AddressAll> listAddress = addressService.findAllAddresses();
        logger.info("m=findAllPersons stage=finish listAddress={}", listAddress);
        return ResponseEntity.ok(listAddress);
    }

    @PostMapping
    public ResponseEntity<Void> insertAddressForPerson(@RequestBody AddressPost addressPost) throws ParseException {
        logger.info("m=insertAddressForPerson stage=init, addressPost={}", addressPost);
        var id = addressService.insertAddressForPerson(addressPost).getId();
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        logger.info("m=insertAddressForPerson stage=finish uri={}", uri);
        return ResponseEntity.created(uri).build();
    }
}
