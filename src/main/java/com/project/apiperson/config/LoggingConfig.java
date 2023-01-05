package com.project.apiperson.config;

import org.slf4j.MDC;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Configuration
public class LoggingConfig extends OncePerRequestFilter {
    private static final String REQUEST_ID = "requestId";

    private void putRequestId() {
        MDC.put(REQUEST_ID, UUID.randomUUID().toString());
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        putRequestId();
        filterChain.doFilter(request, response);
    }
}


