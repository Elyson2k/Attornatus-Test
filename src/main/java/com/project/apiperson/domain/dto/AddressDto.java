package com.project.apiperson.domain.dto;

import com.project.apiperson.domain.entities.Address;
import com.project.apiperson.domain.entities.City;

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


    public String getStreet() {
        return street;
    }


    public String getZipCode() {
        return zipCode;
    }


    public Integer getNumber() {
        return number;
    }


    public City getCity() {
        return city;
    }


}
