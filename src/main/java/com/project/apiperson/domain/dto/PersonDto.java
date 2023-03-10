package com.project.apiperson.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.apiperson.domain.entities.Address;
import com.project.apiperson.domain.entities.Person;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class PersonDto {


    @JsonIgnore
    private Integer id;
    @NotEmpty(message = "This field cannot be null")
    @Length(min = 3, max = 55)
    private String name;

    @NotEmpty(message = "This field cannot be null")
    @Email(message = "EMAIL is invalid format")
    private String email;

    @NotEmpty(message = "This field cannot be null")
    @CPF(message = "CPF is invalid format")
    private String cpf;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    private UUID confirmationToken;

    private boolean accountVerified = true;
    private List<Address> addresses = new ArrayList<>();

    public PersonDto() {
    }

    public PersonDto(Integer id, String name, String email, String cpf, Date dateOfBirth, UUID confirmationToken, boolean accountVerified) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.dateOfBirth = dateOfBirth;
        this.confirmationToken = confirmationToken;
        this.accountVerified = accountVerified;
    }

    public PersonDto(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.email = person.getEmail();
        this.cpf = person.getCpf();
        this.dateOfBirth = person.getDateOfBirth();
        this.addresses = person.getAddresses();
        this.confirmationToken = person.getConfirmationToken();
    }

    public Integer getId() {
        return id;
    }

    public PersonDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PersonDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public PersonDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }


    public List<Address> getAddresses() {
        return addresses;
    }


    public String getCpf() {
        return cpfMask(cpf);
    }

    public UUID getConfirmationToken() {
        return confirmationToken;
    }

    public PersonDto setConfirmationToken(UUID confirmationToken) {
        this.confirmationToken = confirmationToken;
        return this;
    }

    public boolean isAccountVerified() {
        return accountVerified;
    }

    public PersonDto setAccountVerified(boolean accountVerified) {
        this.accountVerified = accountVerified;
        return this;
    }


    public String cpfMask(String cpf) {
        return String.format("%s.%s.%s-%s", cpf.substring(0, 3), cpf.substring(3, 6), cpf.substring(6, 9), cpf.substring(9));
    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", addresses=" + addresses +
                '}';
    }
}
