package com.project.apiperson.domain.entities;

import lombok.ToString;

import javax.persistence.*;
import java.text.ParseException;
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

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;

    @ToString.Exclude
    @OneToMany(mappedBy = "person", fetch = FetchType.EAGER)
    private List<Address> addresses = new ArrayList<>();

    private UUID confirmationToken;

    private boolean accountVerified;

    public Person() {
    }

    public Person(Integer id, String name, String email, String cpf, Date dateOfBirth, UUID confirmationToken, boolean accountVerified) throws ParseException {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.dateOfBirth = dateOfBirth;
        this.confirmationToken = confirmationToken;
        this.accountVerified = accountVerified;
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
        return dateOfBirth;
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

    public UUID getConfirmationToken() {
        return confirmationToken;
    }

    public Person setConfirmationToken(UUID confirmationToken) {
        this.confirmationToken = confirmationToken;
        return this;
    }

    public boolean isAccountVerified() {
        return accountVerified;
    }

    public Person setAccountVerified(boolean accountVerified) {
        this.accountVerified = accountVerified;
        return this;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", addresses=" + addresses +
                '}';
    }

}
