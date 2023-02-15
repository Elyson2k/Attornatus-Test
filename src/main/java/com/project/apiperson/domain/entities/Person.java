package com.project.apiperson.domain.entities;

import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.text.ParseException;
import java.util.*;

@Entity
@Table(name = "tb_person")
public class Person implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String senha;
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

    public Person(Integer id, String name, String email, String senha, String cpf, Date dateOfBirth, UUID confirmationToken, boolean accountVerified) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.senha = senha;
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

    public String getSenha() {
        return senha;
    }

    public Person setSenha(String senha) {
        this.senha = senha;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
