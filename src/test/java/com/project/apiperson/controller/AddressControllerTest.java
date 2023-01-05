package com.project.apiperson.controller;

import com.project.apiperson.domain.dto.AddressAll;
import com.project.apiperson.domain.dto.AddressDto;
import com.project.apiperson.domain.dto.AddressPost;
import com.project.apiperson.domain.entities.Address;
import com.project.apiperson.service.AddressService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.text.ParseException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AddressControllerTest {

    public static final int ID = 1;
    public static final String STREET = "Rua";
    public static final String ZIP_CODE = "ZipCode";
    public static final int NUMBER = 100;
    public static final Character PRIOTIRY_ADDRESS = 'N';

    @InjectMocks
    private AddressController addressController;
    @Mock
    private AddressService addressService;
    private AddressAll addressAll;
    private AddressPost addressPost;
    private AddressDto addressDto;
    private Address address;
    @BeforeEach
    void setUp() throws ParseException {
        MockitoAnnotations.openMocks(this);
        startUser();
        when(addressService.findAddressById(ID)).thenReturn(address);
        when(addressService.findAllAddresses()).thenReturn(List.of(addressAll));
        when(addressService.insertAddressForPerson(addressPost)).thenReturn(address);
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
    }

    @Test
    void findAddress() {
        var response = addressController.findAddress(ID);
        assertNotNull(response);
        assertEquals(ID, response.getBody().getId());
        assertEquals(STREET, response.getBody().getStreet());
        assertEquals(ZIP_CODE, response.getBody().getZipcode());
        assertEquals(NUMBER, response.getBody().getNumber());
    }

    @Test
    void findAllAddresses() {
        var response = addressController.findAllAddress();
        assertNotNull(response);
        assertEquals(ID, response.getBody().get(0).getId());
        assertEquals(STREET, response.getBody().get(0).getStreet());
        assertEquals(ZIP_CODE, response.getBody().get(0).getZipCode());
        assertEquals(NUMBER, response.getBody().get(0).getNumber());
    }

    @Test
    void insertAddressForPerson() throws ParseException {
        var response = addressController.insertAddressForPerson(addressPost);
        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    private void startUser(){
        addressAll = new AddressAll(ID, STREET, ZIP_CODE, NUMBER, PRIOTIRY_ADDRESS);
        addressPost = new AddressPost(ID, STREET, ZIP_CODE, NUMBER,PRIOTIRY_ADDRESS, NUMBER, NUMBER);
        addressDto = new AddressDto(ID, STREET, ZIP_CODE, NUMBER, PRIOTIRY_ADDRESS, null);
        address = new Address(ID, STREET, ZIP_CODE, NUMBER, PRIOTIRY_ADDRESS, null, null);
    }
}