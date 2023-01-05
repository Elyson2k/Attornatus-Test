package com.project.apiperson.domain.dto;

public class AddressPost {

    private Integer id;
    private String street;
    private String zipcode;
    private Integer number;
    private Character priotiryAddress;
    private Integer personId;
    private Integer cityId;

    public AddressPost(Integer id, String street, String zipcode, Integer number, Character priotiryAddress, Integer personId, Integer cityId) {
        this.id = id;
        this.street = street;
        this.zipcode = zipcode;
        this.number = number;
        this.priotiryAddress = priotiryAddress;
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


    public String getZipcode() {
        return zipcode;
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

    public Character getPriotiryAddress() {
        return priotiryAddress;
    }


    @Override
    public String toString() {
        return "AddressPost{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", number=" + number +
                ", personId=" + personId +
                ", cityId=" + cityId +
                '}';
    }
}
