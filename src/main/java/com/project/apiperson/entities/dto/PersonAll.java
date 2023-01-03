package com.project.apiperson.entities.dto;

import com.project.apiperson.entities.Address;
import com.project.apiperson.entities.Person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonAll {

    private Integer id;
    private String name;
    private String email;
    private Date dateOfBirth;

    public PersonAll() {

    }

    public PersonAll(Integer id, String name, String email, Date dateOfBirth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public PersonAll(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.email = person.getEmail();
        this.dateOfBirth = person.getDateOfBirth();
    }

    public Integer getId() {
        return id;
    }

    public PersonAll setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PersonAll setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public PersonAll setEmail(String email) {
        this.email = email;
        return this;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public PersonAll setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }
}
