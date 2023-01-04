package com.project.apiperson.service;

import com.project.apiperson.domain.dto.CityDto;
import com.project.apiperson.domain.entities.City;
import com.project.apiperson.repository.CityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;


class CityServiceTest {

    public static final int ID = 1;
    public static final String CITY = "City";
    @InjectMocks
    private CityService cityService;
    @Mock
    private CityRepository cityRepository;

    City city;
    CityDto cityDto;
    Optional<City> optionalCity;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
        when(cityRepository.findById(ID)).thenReturn(optionalCity);
        when(cityRepository.findAll()).thenReturn(List.of(city));
        when(cityRepository.save(city)).thenReturn(city);
    }

    @Test
    void findCityByID() {
        var response = cityService.findCityByID(ID);
        assertNotNull(response);
        assertEquals(ID, response.getId());
        assertEquals(CITY, response.getName());
    }

    @Test
    void findAllCity() {
        var response = cityService.findAllCity();
        assertNotNull(response);
        assertEquals(ID, response.get(0).getId());
        assertEquals(CITY, response.get(0).getName());
    }

    @Test
    void insertCity(){
        var response = cityService.insertCity(cityDto);
        assertNotNull(response);
        assertEquals(CITY, response.getName());
    }

    private void startUser() {
        city = new City(ID, CITY);
        cityDto = new CityDto(ID, CITY);
        optionalCity = Optional.of(city);
    }
}