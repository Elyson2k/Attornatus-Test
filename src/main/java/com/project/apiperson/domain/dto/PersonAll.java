package com.project.apiperson.domain.dto;

import com.project.apiperson.domain.entities.Person;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PersonAll {
    private Integer id;
    private String name;
    private String email;

    private String cpf;
    private Date dateOfBirth;

    public PersonAll() {

    }

    public PersonAll(Integer id, String name, String email, String cpf, Date dateOfBirth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.dateOfBirth = dateOfBirth;
    }

    public PersonAll(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.email = person.getEmail();
        this.cpf = person.getCpf();
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

    public String getCpf() {
        return cpf;
    }


    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return "PersonAll{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
