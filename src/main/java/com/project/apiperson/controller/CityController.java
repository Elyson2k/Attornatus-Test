package com.project.apiperson.controller;


import com.project.apiperson.entities.City;
import com.project.apiperson.entities.dto.CityDto;
import com.project.apiperson.entities.dto.PersonPost;
import com.project.apiperson.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/cities")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CityDto> findCityById(@PathVariable Integer id){
        City city = cityService.findCityByID(id);
        return ResponseEntity.ok(new CityDto(city));
    }

    @GetMapping
    public ResponseEntity<List<CityDto>> findAllCities(){
        List<CityDto> citiesDto = cityService.findAllCity();
        return ResponseEntity.ok(citiesDto);
    }

    @PostMapping
    public ResponseEntity<Void> inserCity(@Valid @RequestBody CityDto cityDto){
        var id = cityService.insertCity(cityDto).getId();
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }
}
