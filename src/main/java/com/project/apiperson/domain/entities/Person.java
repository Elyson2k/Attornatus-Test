package com.project.apiperson.domain.entities;

import lombok.ToString;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "tb_person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    @Column(unique = true)
    private String cpf;
    private Date dateOfBirth;

    @ToString.Exclude
    @OneToMany(mappedBy = "person", fetch = FetchType.EAGER)
    private List<Address> addresses = new ArrayList<>();

    public Person() {
    }

    public Person(Integer id, String name, String email, String cpf, Date dateOfBirth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.dateOfBirth = dateOfBirth;
    }

    public Person(Person newPerson) {
        Person person = newPerson.setId(null);
        person.setName(newPerson.getName());
        person.setEmail(newPerson.getEmail());
        person.setAddresses(newPerson.getAddresses());
        person.setDateOfBirth(newPerson.getDateOfBirth());
    }

    public Integer getId() {
        return id;
    }

    public Person setId(Integer id) {
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

    public String getEmail() {
        return email;
    }

    public Person setEmail(String email) {
        this.email = email;
        return this;
    }

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public Person setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public Person setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public Person setAddresses(List<Address> addresses) {
        this.addresses = addresses;
        return this;
    }

}
