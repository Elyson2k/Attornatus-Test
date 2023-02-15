package com.project.apiperson.config.security;

import com.project.apiperson.domain.entities.Person;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    public String gerarToken(Authentication authentication){

        Person logado = (Person) authentication.getPrincipal();
        Date hoje = new Date();
        Date dataExpToken = new Date(hoje.getTime() + 86400000);

        return Jwts.builder()
                .setIssuer("NOME_DA_API")
                .setSubject(logado.getId().toString())
                .setIssuedAt(hoje)
                .setExpiration(dataExpToken)
                .signWith(SignatureAlgorithm.HS256, "oqPdOpK8eh9K&yV^VcYhJ9sjzerG7rk7e8ZGrY19KkN@eYiz2H").compact();
    }

}
