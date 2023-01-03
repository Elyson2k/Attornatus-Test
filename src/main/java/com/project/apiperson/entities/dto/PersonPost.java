package com.project.apiperson.entities.dto;

import com.project.apiperson.entities.Address;
import com.project.apiperson.entities.Person;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonPost {

    @NotEmpty(message = "This field cannot be null")
    @Length(min = 3, max = 55)
    private String name;

    @NotEmpty(message = "This field cannot be null")
    @Email(message = "EMAIL is invalid format")
    private String email;

    @NotEmpty(message = "This field cannot be null")
    @CPF(message = "CPF is invalid format")
    private String cpf;

    @NotNull
    private Date dateOfBirth;

    @NotEmpty(message = "This field cannot be null")
    private String street;

    @NotEmpty(message = "This field cannot be null")
    private String zipCode;

    private Integer number;


    private Integer cityId;

    public PersonPost() {
    }

    public String getName() {
        return name;
    }

    public PersonPost setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public PersonPost setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public PersonPost setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public PersonPost setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public PersonPost setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getZipCode() {
        return zipCode;
    }

    public PersonPost setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public Integer getNumber() {
        return number;
    }

    public PersonPost setNumber(Integer number) {
        this.number = number;
        return this;
    }

    public Integer getCityId() {
        return cityId;
    }

    public PersonPost setCityId(Integer cityId) {
        this.cityId = cityId;
        return this;
    }
}
