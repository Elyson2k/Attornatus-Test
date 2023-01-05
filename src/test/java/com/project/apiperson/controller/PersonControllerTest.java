package com.project.apiperson.controller;

import com.project.apiperson.domain.dto.PersonAll;
import com.project.apiperson.domain.dto.PersonDto;
import com.project.apiperson.domain.dto.PersonPost;
import com.project.apiperson.domain.dto.PersonPut;
import com.project.apiperson.domain.entities.Address;
import com.project.apiperson.domain.entities.City;
import com.project.apiperson.domain.entities.Person;
import com.project.apiperson.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

class PersonControllerTest {

    public static final int ID = 1;
    public static final String NAME_PERSON = "Elyson";
    public static final String STREET = "Rua";
    public static final String CITY = "City";
    public static final String EMAIL = "ElysonV@Outlook.com";
    public static final String CPF = "00000000000";
    public static final String ZIP_CODE = "ZipCode";
    public static final String DATE = "25-02-2003";
    public static final int NUMBER = 100;
    public static final Character PRIOTIRY_ADDRESS = 'N';

    Person person;
    Optional<Person> optionalPersonDto;
    PersonAll personAll;
    private PersonPost personPost;
    private PersonDto personDto;

    private PersonPut personPut;
    private Address address;
    @InjectMocks
    private PersonController personController;
    @Mock
    private PersonService personService;


    @BeforeEach
    void setUp() throws ParseException {
        MockitoAnnotations.openMocks(this);
        startUser();
        when(personService.findAllPerson()).thenReturn(List.of(personAll));
        when(personService.findPersonByID(ID)).thenReturn(person);
        when(personService.insertPerson(personPost)).thenReturn(person);
        when(personService.chancePerson(personPut)).thenReturn(person);
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
    }

    @Test
    void findPerson() {
        var response = personController.findPerson(ID);
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(PersonDto.class, response.getBody().getClass());
        assertEquals(ID, response.getBody().getId());
        assertEquals(NAME_PERSON, response.getBody().getName());
        assertEquals(EMAIL, response.getBody().getEmail());
    }

    @Test
    void findListPersons() {
        var response = personController.findListPersons();
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(PersonAll.class, response.getBody().get(0).getClass());
        assertEquals(ID, response.getBody().get(0).getId());
        assertEquals(NAME_PERSON, response.getBody().get(0).getName());
        assertEquals(EMAIL, response.getBody().get(0).getEmail());
    }

    @Test
    void updatePerson() {
        var response = personController.updatePerson(ID, personPut).getStatusCode();
        assertEquals(HttpStatus.OK, response);
    }

    @Test
    void insertPerson() {
        var response = personController.insertPerson(personPost);
        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    public void startUser() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        City city = new City(ID, CITY);
        person = new Person(ID, NAME_PERSON, EMAIL, CPF , sdf.parse(DATE));
        address = new Address(ID, STREET, ZIP_CODE, 100, PRIOTIRY_ADDRESS, person, city);
        personAll = new PersonAll(ID, NAME_PERSON, EMAIL, CPF, sdf.parse(DATE));
        personDto = new PersonDto(ID, NAME_PERSON, EMAIL, CPF , sdf.parse(DATE));
        personPut = new PersonPut(ID,NAME_PERSON,EMAIL, NUMBER, PRIOTIRY_ADDRESS);
        personPost = new PersonPost(NAME_PERSON, EMAIL, CPF, sdf.parse(DATE), STREET, ZIP_CODE, NUMBER, PRIOTIRY_ADDRESS , NUMBER);
        optionalPersonDto = Optional.of(person);
    }
}