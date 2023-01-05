package com.project.apiperson.domain.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "tb_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String street;
    private String zipcode;
    private Integer number;

    @ToString.Exclude
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ToString.Exclude
    @ManyToOne
    private City city;

    public Address() {
    }

    public Address(Integer id, String street, String zipcode, Integer number, Person person, City city) {
        this.id = id;
        this.street = street;
        this.zipcode = zipcode;
        this.number = number;
        this.person = person;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public Integer getNumber() {
        return number;
    }

    public String getZipcode() {
        return maskZipCode(zipcode);
    }

    public Person getPerson() {
        return person;
    }

    public City getCity() {
        return city;
    }

    private String maskZipCode(String zipcode) {
        return String.format("%05d-%02d", Long.parseLong(zipcode.substring(0, 5)), Long.parseLong(zipcode.substring(5)));
    }

    @Override
    public String toString() {
        return "Address{" + "id=" + id + ", street='" + street + '\'' + ", zipCode='" + zipcode + '\'' + ", number=" + number + ", person=" + person.getName() + ", city=" + city + '}';
    }
}
