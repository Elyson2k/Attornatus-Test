package com.project.apiperson.domain.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class PersonPost {

    @NotEmpty(message = "This field cannot be null")
    @Length(min = 3, max = 55)
    private String name;

    @NotEmpty(message = "This field cannot be null")
    @Email(message = "EMAIL is invalid format")
    private String email;

    @NotEmpty(message = "This field cannot be null")
    @CPF(message = "CPF is invalid format")
    private String cpf;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @NotEmpty(message = "This field cannot be null")
    private String street;

    @NotEmpty(message = "This field cannot be null")
    private String zipCode;

    private Integer number;

    private Character priorityAddress = 'N';

    private Integer cityId;

    public PersonPost() {
    }

    public PersonPost(String name, String email, String cpf, Date dateOfBirth, String street, String zipCode, Integer number, Character priorityAddress, Integer cityId) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.dateOfBirth = dateOfBirth;
        this.street = street;
        this.zipCode = zipCode;
        this.number = number;
        this.priorityAddress = priorityAddress;
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public PersonPost setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public PersonPost setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getCpf() {
        return cpf;
    }


    public Date getDateOfBirth() {
        return dateOfBirth;
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


    public Integer getCityId() {
        return cityId;
    }

    public Character getPriorityAddress() {
        return priorityAddress;
    }

    public PersonPost setPriorityAddress(Character priorityAddress) {
        this.priorityAddress = priorityAddress;
        return this;
    }

    @Override
    public String toString() {
        return "PersonPost{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", number=" + number +
                ", priorityAddress= " + priorityAddress +
                ", cityId=" + cityId +
                '}';
    }
}
