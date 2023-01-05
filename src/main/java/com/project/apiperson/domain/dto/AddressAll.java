package com.project.apiperson.domain.dto;

import com.project.apiperson.domain.entities.Address;

public class AddressAll {

    private Integer id;
    private String street;
    private String zipCode;
    private Integer number;
    private Character priorityCharacter = 'N';

    public AddressAll(Integer id, String street, String zipCode, Integer number, Character priorityCharacter) {
        this.id = id;
        this.priorityCharacter = priorityCharacter;
        this.street = street;
        this.zipCode = zipCode;
        this.number = number;
    }

    public AddressAll(Address address) {
        this.id = address.getId();
        this.priorityCharacter = address.getPriorityAddress();
        this.street = address.getStreet();
        this.zipCode = address.getZipcode();
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

    public Character getPriorityCharacter() {
        return priorityCharacter;
    }

    public AddressAll setPriorityCharacter(Character priorityCharacter) {
        this.priorityCharacter = priorityCharacter;
        return this;
    }

    @Override
    public String toString() {
        return "AddressAll{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", number=" + number +
                ", priorityCharacter=" + priorityCharacter +
                '}';
    }
}
