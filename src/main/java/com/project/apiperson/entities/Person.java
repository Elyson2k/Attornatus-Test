package com.project.apiperson.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String name;
    private Date dateOfBirth;

    @OneToMany
    private Set<Address> addresses = new HashSet<>();

    public Person() {
    }

    public Person(UUID id, String name, Date dateOfBirth) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public UUID getId() {
        return id;
    }

    public Person setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Person setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public Person setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
        return this;
    }
}
