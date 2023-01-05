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

    @Column(name = "zipcode")
    private String zipcode;
    private Integer number;

    @Column(name = "priorityaddress")
    private Character priorityAddress;

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

    public Address(Integer id, String street, String zipcode, Integer number , Character priorityAddress, Person person, City city) {
        this.id = id;
        this.street = street;
        this.zipcode = zipcode;
        this.number = number;
        this.priorityAddress = priorityAddress;
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
        return zipcode;
    }

    public Character getPriorityAddress() {
        return priorityAddress;
    }

    @JsonIgnore
    public Person getPerson() {
        return person;
    }

    public City getCity() {
        return city;
    }

    public Address setPerson(Person person) {
        this.person = person;
        return this;
    }

    public Address setCity(City city) {
        this.city = city;
        return this;
    }

    public Address setPriorityAddress(Character priorityAddress) {
        this.priorityAddress = priorityAddress;
        return this;
    }

    private String maskZipCode(String zipcode) {
        return String.format("%05d-%02d", Long.parseLong(zipcode.substring(0, 5)), Long.parseLong(zipcode.substring(5)));
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", number=" + number +
                ", priorityAddress=" + priorityAddress +
                ", person=" + person.getName() +
                ", city=" + city +
                '}';
    }
}
