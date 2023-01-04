package com.project.apiperson.domain.dto;

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


    public String getZipCode() {
        return zipCode;
    }


    public Integer getNumber() {
        return number;
    }


    public Integer getPersonId() {
        return personId;
    }


    public Integer getCityId() {
        return cityId;
    }

    @Override
    public String toString() {
        return "AddressPost{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", number=" + number +
                ", personId=" + personId +
                ", cityId=" + cityId +
                '}';
    }
}
