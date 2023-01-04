package com.project.apiperson.domain.dto;

import com.project.apiperson.domain.entities.Address;

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


    public String getStreet() {
        return street;
    }


    public String getZipCode() {
        return zipCode;
    }


    public Integer getNumber() {
        return number;
    }

}
