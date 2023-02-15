package com.project.apiperson.controller.impl;

import com.project.apiperson.config.security.TokenService;
import com.project.apiperson.domain.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<?> autenticar(@Valid @RequestBody LoginForm loginForm){
        UsernamePasswordAuthenticationToken dadosLogin = new UsernamePasswordAuthenticationToken(loginForm.getEmail(), loginForm.getSenha());
        try {
            Authentication authentication = authenticationManager.authenticate(dadosLogin);
            String token = tokenService.gerarToken(authentication);

            return ResponseEntity.ok().build();
        } catch (AuthenticationException e){
            return ResponseEntity.badRequest().build();
        }
    }

}
