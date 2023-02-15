package com.project.apiperson.domain;

public class LoginForm {

    private String email;
    private String senha;

    public String getEmail() {
        return email;
    }

    public LoginForm setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getSenha() {
        return senha;
    }

    public LoginForm setSenha(String senha) {
        this.senha = senha;
        return this;
    }
}
