package com.project.apiperson.domain.dto;

import com.project.apiperson.domain.entities.Address;
import com.project.apiperson.domain.entities.City;

public class AddressDto {

    private Integer id;
    private String street;
    private String zipcode;
    private Integer number;
    private Character priorityAddress = 'N';
    private City city;

    public AddressDto(Integer id, String street, String zipcode, Integer number, Character priorityAddress, City city) {
        this.id = id;
        this.street = street;
        this.zipcode = zipcode;
        this.number = number;
        this.priorityAddress = priorityAddress;
        this.city = city;
    }

    public AddressDto(Address address) {
        this.id = address.getId();
        this.priorityAddress = address.getPriorityAddress();
        this.street = address.getStreet();
        this.zipcode = address.getZipcode();
        this.number = address.getNumber();
        this.city = address.getCity();
    }

    public Integer getId() {
        return id;
    }


    public String getStreet() {
        return street;
    }


    public String getZipcode() {
        return zipcode;
    }


    public Integer getNumber() {
        return number;
    }


    public City getCity() {
        return city;
    }

    public Character getPriorityAddress() {
        return priorityAddress;
    }


    @Override
    public String toString() {
        return "AddressDto{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", zipCode='" + zipcode + '\'' +
                ", number=" + number +
                ", city=" + city.getName() +
                '}';
    }
}
