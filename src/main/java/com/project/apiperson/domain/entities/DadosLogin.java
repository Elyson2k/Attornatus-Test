package com.project.apiperson.domain.entities;

public class DadosLogin {

    private String token;
    private String name;

    public DadosLogin(String token, String name) {
        this.token = token;
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public DadosLogin setToken(String token) {
        this.token = token;
        return this;
    }

    public String getName() {
        return name;
    }

    public DadosLogin setName(String name) {
        this.name = name;
        return this;
    }
}
