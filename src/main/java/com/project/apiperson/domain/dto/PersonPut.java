package com.project.apiperson.domain.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.apiperson.domain.entities.Person;

public class PersonPut {

    @JsonIgnore
    private Integer id;
    private String name;
    private String email;
    private Integer addressId;
    private Character priorityAddress;

    public PersonPut(Integer id, String name, String email, Integer addressId, Character priorityAddress) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.addressId = addressId;
        this.priorityAddress = priorityAddress;
    }

    public PersonPut(Person person){
        this.id = person.getId();
        this.name = person.getName();
        this.email = person.getEmail();
    }

    public String getName() {
        return name;
    }

    public PersonPut setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Character getPriorityAddress() {
        return priorityAddress;
    }


    @JsonIgnore
    public Integer getId() {
        return id;
    }

    public PersonPut setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public PersonPut setAddressId(Integer addressId) {
        this.addressId = addressId;
        return this;
    }

    @Override
    public String toString() {
        return "PersonPut{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", priorityAddress" + priorityAddress +
                '}';
    }
}
