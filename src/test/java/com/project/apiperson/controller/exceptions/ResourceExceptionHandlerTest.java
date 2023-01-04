package com.project.apiperson.controller.exceptions;

import com.project.apiperson.service.exceptions.CustomExceptions;
import com.project.apiperson.service.exceptions.DataIntegrityViolationException;
import com.project.apiperson.service.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ResourceExceptionHandlerTest {

    public static final String ERROR_ENTITY_NOT_FOUND = "Error: Entity not found.";
    public static final String ERROR_EMAIL_IS_ALREADY_BEING_USED = "Error: email is already being used.";
    public static final String ERROR_NO_ADDRESS_FOUND = "Error: no address found.";
    @InjectMocks
    private ResourceExceptionHandler resourceExceptionHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void objNotFound() {
        ResponseEntity<StandardError> response = resourceExceptionHandler.objNotFound(new ObjectNotFoundException(ERROR_ENTITY_NOT_FOUND), null);
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void dataIntegrity() {
        ResponseEntity<StandardError> response = resourceExceptionHandler.dataIntegrity(new DataIntegrityViolationException(ERROR_EMAIL_IS_ALREADY_BEING_USED), null);
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void customError() {
        ResponseEntity<StandardError> response = resourceExceptionHandler.customError(new CustomExceptions(ERROR_NO_ADDRESS_FOUND), null);
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void errorCpfIsAlready(){
        ResponseEntity<StandardError> methodX = resourceExceptionHandler.sqlError(new SQLIntegrityConstraintViolationException("Erros de validação"), null);
        assertNotNull(methodX);
        assertNotNull(methodX.getBody());
        assertEquals(HttpStatus.CONFLICT, methodX.getStatusCode());
    }


    @Test
    public void testMethodValidation() {
        MethodArgumentNotValidException exception = new MethodArgumentNotValidException(null, new BeanPropertyBindingResult(new Object(), "objeto"));
        HttpServletRequest request = mock(HttpServletRequest.class);
        var response = resourceExceptionHandler.methodValidation(exception, request).getStatusCode();

        ValidationError error = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Erros de validação", System.currentTimeMillis());
        error.addError("field1", "message1");
        error.addError("field2", "message2");
        var expected = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error).getStatusCode();

        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response);
        assertEquals(expected, response);

    }
}