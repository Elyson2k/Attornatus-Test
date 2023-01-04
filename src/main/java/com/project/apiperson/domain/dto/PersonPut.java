package com.project.apiperson.domain.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.apiperson.domain.entities.Person;

public class PersonPut {

    @JsonIgnore
    private Integer id;
    private String name;
    private String email;

    public PersonPut(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public PersonPut setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public PersonPut setEmail(String email) {
        this.email = email;
        return this;
    }

    @JsonIgnore
    public Integer getId() {
        return id;
    }

    public PersonPut setId(Integer id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return "PersonPut{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
