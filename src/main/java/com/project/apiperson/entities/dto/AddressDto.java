package com.project.apiperson.entities.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.apiperson.entities.Address;
import com.project.apiperson.entities.City;
import com.project.apiperson.entities.Person;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class AddressDto {

    private Integer id;
    private String street;
    private String zipCode;
    private Integer number;
    private City city;

    public AddressDto(Integer id, String street, String zipCode, Integer number, City city) {
        this.id = id;
        this.street = street;
        this.zipCode = zipCode;
        this.number = number;
        this.city = city;
    }

    public AddressDto(Address address) {
        this.id = address.getId();
        this.street = address.getStreet();
        this.zipCode = address.getZipCode();
        this.number = address.getNumber();
        this.city = address.getCity();
    }

    public Integer getId() {
        return id;
    }

    public AddressDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public AddressDto setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getZipCode() {
        return zipCode;
    }

    public AddressDto setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public Integer getNumber() {
        return number;
    }

    public AddressDto setNumber(Integer number) {
        this.number = number;
        return this;
    }

    public City getCity() {
        return city;
    }

    public AddressDto setCity(City city) {
        this.city = city;
        return this;
    }

}
