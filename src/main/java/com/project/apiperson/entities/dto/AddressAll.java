package com.project.apiperson.entities.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.apiperson.entities.Address;
import com.project.apiperson.entities.City;
import com.project.apiperson.entities.Person;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class AddressAll {

    private Integer id;
    private String street;
    private String zipCode;
    private Integer number;

    public AddressAll(Integer id, String street, String zipCode, Integer number) {
        this.id = id;
        this.street = street;
        this.zipCode = zipCode;
        this.number = number;
    }

    public AddressAll(Address address) {
        this.id = address.getId();
        this.street = address.getStreet();
        this.zipCode = address.getZipCode();
        this.number = address.getNumber();
    }

    public Integer getId() {
        return id;
    }

    public AddressAll setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public AddressAll setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getZipCode() {
        return zipCode;
    }

    public AddressAll setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public Integer getNumber() {
        return number;
    }

    public AddressAll setNumber(Integer number) {
        this.number = number;
        return this;
    }
}
