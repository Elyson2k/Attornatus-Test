package com.project.apiperson.domain.dto;

import com.project.apiperson.domain.entities.Person;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.UUID;

public class PersonAll {
    private Integer id;
    private String name;
    private String email;

    private String cpf;

    private UUID confirmationToken;

    private boolean accountVerified = true;
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    public PersonAll() {

    }

    public PersonAll(Integer id, String name, String email, String cpf, Date dateOfBirth, UUID confirmationToken, boolean accountVerified) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.dateOfBirth = dateOfBirth;
        this.confirmationToken = confirmationToken;
        this.accountVerified = accountVerified;
    }

    public PersonAll(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.email = person.getEmail();
        this.cpf = person.getCpf();
        this.dateOfBirth = person.getDateOfBirth();
        this.confirmationToken = person.getConfirmationToken();
    }

    public Integer getId() {
        return id;
    }

    public PersonAll setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PersonAll setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public PersonAll setEmail(String email) {
        this.email = email;
        return this;
    }

    public UUID getConfirmationToken() {
        return confirmationToken;
    }

    public PersonAll setConfirmationToken(UUID confirmationToken) {
        this.confirmationToken = confirmationToken;
        return this;
    }

    public boolean isAccountVerified() {
        return accountVerified;
    }

    public PersonAll setAccountVerified(boolean accountVerified) {
        this.accountVerified = accountVerified;
        return this;
    }

    public String getCpf() {
        return cpfMask(cpf);
    }


    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String cpfMask(String cpf) {
        return String.format("%s.%s.%s-%s", cpf.substring(0, 3), cpf.substring(3, 6), cpf.substring(6, 9), cpf.substring(9));
    }

    @Override
    public String toString() {
        return "PersonAll{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
