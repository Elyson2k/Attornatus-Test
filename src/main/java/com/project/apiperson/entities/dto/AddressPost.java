package com.project.apiperson.entities.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.apiperson.entities.Person;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class AddressPost {

    private Integer id;
    private String street;
    private String zipCode;
    private Integer number;
    private Integer personId;
    private Integer cityId;

    public AddressPost(Integer id, String street, String zipCode, Integer number, Integer personId, Integer cityId) {
        this.id = id;
        this.street = street;
        this.zipCode = zipCode;
        this.number = number;
        this.personId = personId;
        this.cityId = cityId;
    }

    public Integer getId() {
        return id;
    }

    public AddressPost setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public AddressPost setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getZipCode() {
        return zipCode;
    }

    public AddressPost setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public Integer getNumber() {
        return number;
    }

    public AddressPost setNumber(Integer number) {
        this.number = number;
        return this;
    }

    public Integer getPersonId() {
        return personId;
    }

    public AddressPost setPersonId(Integer personId) {
        this.personId = personId;
        return this;
    }

    public Integer getCityId() {
        return cityId;
    }

    public AddressPost setCityId(Integer cityId) {
        this.cityId = cityId;
        return this;
    }
}
