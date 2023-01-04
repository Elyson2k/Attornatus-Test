package com.project.apiperson.service;

import com.project.apiperson.domain.dto.AddressAll;
import com.project.apiperson.domain.dto.AddressPost;
import com.project.apiperson.domain.entities.Address;
import com.project.apiperson.domain.entities.City;
import com.project.apiperson.domain.entities.Person;
import com.project.apiperson.repository.AddressRepository;
import com.project.apiperson.service.exceptions.CustomExceptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AddressServiceTest {

    public static final int ID = 1;
    public static final String NAME_PERSON = "Elyson";
    public static final String STREET = "Rua";
    public static final String CITY = "City";
    public static final String EMAIL = "ElysonV@Outlook.com";
    public static final String CPF = "00000000000";
    public static final String ZIP_CODE = "ZipCode";
    public static final String DATE = "25-02-2003";
    public static final int NUMBER = 100;

    @InjectMocks
    private AddressService addressService;
    @Mock
    private AddressRepository addressRepository;
    @Mock
    private PersonService personService;
    @Mock
    private CityService cityService;


    Address address;
    Optional<Address> addressOptional;
    AddressAll addressAll;
    AddressPost addressPost;
    Person person;

    @BeforeEach
    void setUp() throws ParseException {
        MockitoAnnotations.openMocks(this);
        startUser();
        when(addressRepository.findById(ID)).thenReturn(addressOptional);
        when(addressRepository.findAll()).thenReturn(List.of(address));
        when(addressRepository.save(address)).thenReturn(address);
    }

    @Test
    void findAddressByID() {
        var response = addressService.findAddressByID(ID);
        assertNotNull(response);
        assertEquals(STREET, response.getStreet());
        assertEquals(ZIP_CODE, response.getZipCode());
        assertEquals(NUMBER, response.getNumber());
    }

    @Test
    void listAddress() {
        var response = addressService.findAllAddresses();
        assertNotNull(response);
        assertEquals(STREET, response.get(0).getStreet());
        assertEquals(ZIP_CODE, response.get(0).getZipCode());
        assertEquals(NUMBER ,  response.get(0).getNumber());
    }

    @Test
    void insertAddressForPerson() {
        var response = addressService.insertAddressForPerson(addressPost);
        assertNotNull(response);
        assertEquals(STREET, response.getStreet());
        assertEquals(ZIP_CODE, response.getZipCode());
        assertEquals(NUMBER, response.getNumber());
    }

    public void startUser() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        City city = new City(ID, CITY);
        person = new Person(ID, NAME_PERSON, EMAIL, CPF , sdf.parse(DATE));
        address = new Address(ID, STREET, ZIP_CODE, NUMBER, person, city);
        addressOptional = Optional.of(address);
        addressAll = new AddressAll(ID, STREET, ZIP_CODE, NUMBER);
        addressPost = new AddressPost(ID, STREET, ZIP_CODE, NUMBER, NUMBER, NUMBER);
    }
}