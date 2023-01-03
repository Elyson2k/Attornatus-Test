package com.project.apiperson.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "tb_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String street;
    private String zipCode;
    private Integer number;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    private City city;

    public Address() {
    }

    public Address(Integer id, String street, String zipCode, Integer number, Person person, City city) {
        this.id = id;
        this.street = street;
        this.zipCode = zipCode;
        this.number = number;
        this.person = person;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public Address setId(Integer id) {
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

    public String getZipCode() {
        return zipCode;
    }

    public Address setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public Person getPerson() {
        return person;
    }

    public Address setPerson(Person person) {
        this.person = person;
        return this;
    }

    public City getCity() {
        return city;
    }

    public Address setCity(City city) {
        this.city = city;
        return this;
    }
}
