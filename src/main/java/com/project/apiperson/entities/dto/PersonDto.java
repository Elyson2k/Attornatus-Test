package com.project.apiperson.entities.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.apiperson.entities.Address;
import com.project.apiperson.entities.Person;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonDto {

    @JsonIgnore
    private Integer id;
    @NotEmpty(message = "This field cannot be null")
    @Length(min = 3, max = 55)
    private String name;

    @NotEmpty(message = "This field cannot be null")
    @Email(message = "EMAIL is invalid format")
    private String email;

    @NotEmpty(message = "This field cannot be null")
    @CPF(message = "CPF is invalid format")
    private String cpf;
    private Date dateOfBirth;
    private List<Address> addresses = new ArrayList<>();

    public PersonDto() {
    }

    public PersonDto(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.email = person.getEmail();
        this.cpf = person.getCpf();
        this.dateOfBirth = person.getDateOfBirth();
        this.addresses = person.getAddresses();
    }

    public Integer getId() {
        return id;
    }

    public PersonDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PersonDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public PersonDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public PersonDto setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }


    public List<Address> getAddresses() {
        return addresses;
    }

    public PersonDto setAddresses(List<Address> addresses) {
        this.addresses = addresses;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public PersonDto setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }
}
