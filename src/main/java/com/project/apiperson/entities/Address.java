package com.project.apiperson.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String street;
    private Integer number;

    public Address() {
    }

    public Address(UUID id, String street, Integer number) {
        this.id = id;
        this.street = street;
        this.number = number;
    }

    public UUID getId() {
        return id;
    }

    public Address setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public Address setStreet(String street) {
        this.street = street;
        return this;
    }

    public Integer getNumber() {
        return number;
    }

    public Address setNumber(Integer number) {
        this.number = number;
        return this;
    }
}
