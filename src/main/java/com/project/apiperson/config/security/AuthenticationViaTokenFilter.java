package com.project.apiperson.config.security;

import com.project.apiperson.repository.PersonRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationViaTokenFilter extends OncePerRequestFilter {

    private final TokenService tokenService;
    private PersonRepository repository;

    public AuthenticationViaTokenFilter(TokenService tokenService, PersonRepository repository) {
        this.tokenService = tokenService;
        this.repository = repository;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = recuperarToken(request);
        Boolean isValid = tokenService.isTokenValid(token);
        if(isValid){
            autenticarClient(token);
        }

        filterChain.doFilter(request,response);
    }

    private void autenticarClient(String token) {
        Integer id = tokenService.getIdUser(token);
        var person = repository.findById(id).get();
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(person, null, person.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private String recuperarToken(HttpServletRequest request) {

        String token = request.getHeader("Authorization");
        if(token == null || token.isEmpty() || !token.startsWith("Bearer ")){
            return null;
        }
        return token.substring(7,token.length());

    }
}
