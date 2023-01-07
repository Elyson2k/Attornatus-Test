package com.project.apiperson.service;

import com.project.apiperson.domain.dto.PersonAll;
import com.project.apiperson.domain.dto.PersonDto;
import com.project.apiperson.domain.dto.PersonPost;
import com.project.apiperson.domain.dto.PersonPut;
import com.project.apiperson.domain.entities.Address;
import com.project.apiperson.domain.entities.City;
import com.project.apiperson.domain.entities.Person;
import com.project.apiperson.repository.AddressRepository;
import com.project.apiperson.repository.PersonRepository;
import com.project.apiperson.service.exceptions.CustomExceptions;
import com.project.apiperson.service.exceptions.DataIntegrityViolationException;
import com.project.apiperson.service.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.mail.MessagingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PersonServiceTest {

    public static final int ID = 1;
    public static final String NAME_PERSON = "Elyson";
    public static final String STREET = "Rua";
    public static final String CITY = "City";
    public static final String EMAIL = "ElysonV@Outlook.com";
    public static final String CPF = "00000000000";
    public static final String ZIP_CODE = "ZipCode";
    public static final String DATE = "25-02-2003";
    public static final int NUMBER = 100;
    public static final String ERROR_EMAIL_IS_ALREADY_BEING_USED = "Error: email is already being used.";
    public static final String ERROR_ENTITY_NOT_FOUND = "Error: Entity not found.";
    public static final String ERROR_NO_PERSON_FOUND = "Error: no person found.";
    public static final String DATE_FORMAT = "dd-MM-yyyy";
    public static final Character PRIOTIRY_ADDRESS = 'N';
    public static final char N = 'N';

    @InjectMocks
    private PersonService personService;
    @Mock
    private PersonRepository personRepository;

    @Mock
    private AddressRepository addressRepository;
    Person person;
    Optional<Person> optionalPersonDto;
    PersonAll personAll;
    private PersonPost personPost;
    private PersonDto personDto;
    private Address address;
    private PersonPut personPut;

    @BeforeEach
    void setUp() throws ParseException {
        MockitoAnnotations.openMocks(this);
        startUser();
        when(personRepository.findAll()).thenReturn(List.of(person));
        when(personRepository.findById(ID)).thenReturn(Optional.of(person));
        when(personRepository.save(person)).thenReturn(person);
    }


    @Test
    void findPersonByID() {
        var response = personService.findPersonByID(ID);
        assertNotNull(response);
        assertEquals(NAME_PERSON, response.getName());
        assertEquals(EMAIL, response.getEmail());
        assertEquals(CPF, response.getCpf());
    }

    @Test
    void findAllPerson() {
        var response = personService.findAllPerson();
        assertNotNull(response);
        assertEquals(ID, response.get(0).getId());
        assertEquals(NAME_PERSON, response.get(0).getName());
        assertEquals(EMAIL, response.get(0).getEmail());
    }


    @Test
    void insertPerson() throws MessagingException {

        var response = personService.insertPerson(personPost);
        assertNotNull(response);
        assertEquals(NAME_PERSON, response.getName());
        assertEquals(EMAIL, response.getEmail());
        assertEquals(CPF, response.getCpf());
        assertEquals(STREET, response.getAddresses().get(0).getStreet());
        assertEquals(ZIP_CODE, response.getAddresses().get(0).getZipcode());
        assertEquals(NUMBER ,  response.getAddresses().get(0).getNumber());
    }


    @Test
    void testErrorObjectNotFound(){
        when(personRepository.findById(ID)).thenThrow(new ObjectNotFoundException(ERROR_ENTITY_NOT_FOUND));
        try{
            personService.findPersonByID(ID);
        } catch (Exception ex){
            assertEquals(ObjectNotFoundException.class, ex.getClass());
            assertEquals(ERROR_ENTITY_NOT_FOUND, ex.getMessage());
        }
    }


    @Test
    void testErrorCustom(){
        when(personRepository.findAll()).thenThrow(new CustomExceptions(ERROR_NO_PERSON_FOUND));
        try{
            personService.findAllPerson();
        } catch (Exception ex){
            assertEquals(CustomExceptions.class, ex.getClass());
            assertEquals(ERROR_NO_PERSON_FOUND, ex.getMessage());
        }
    }

    @Test
    void testErrorCustomOuther(){
        when(personRepository.findAll()).thenThrow(new CustomExceptions(ERROR_NO_PERSON_FOUND));
        try{
            var response = personService.findAllPerson();
        } catch (Exception ex){
            assertEquals(CustomExceptions.class, ex.getClass());
            assertEquals(ERROR_NO_PERSON_FOUND, ex.getMessage());
        }
    }

    @Test
    void test(){
        var response = personService.changePerson(ID, personPut);
        assertNotNull(response);
    }


    public void startUser() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

        City city = new City(ID, CITY);
        person = new Person(ID, NAME_PERSON, EMAIL, CPF , sdf.parse(DATE), null, false);
        address = new Address(ID, STREET, ZIP_CODE, 100, PRIOTIRY_ADDRESS, person, city);
        personAll = new PersonAll(ID, NAME_PERSON, EMAIL, CPF, sdf.parse(DATE), null, false);
        personDto = new PersonDto(ID, NAME_PERSON, EMAIL, CPF , sdf.parse(DATE), null, false);
        personPut = new PersonPut(ID, NAME_PERSON, EMAIL, NUMBER, N);
        personPost = new PersonPost(NAME_PERSON, EMAIL, CPF, sdf.parse(DATE), STREET, ZIP_CODE, NUMBER, PRIOTIRY_ADDRESS ,NUMBER);
        optionalPersonDto = Optional.of(person);
    }
}