package com.project.apiperson.service;

import com.project.apiperson.controller.impl.AddressControllerImpl;
import com.project.apiperson.domain.entities.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

    private final Logger logger = LoggerFactory.getLogger(EmailService.class);

    @Value("${email.username}")
    private String from;
    private final JavaMailSender emailSender;

    public EmailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendSimpleMessage(Person person) {
        logger.info("m=sendSimpleMessage stage=init person={}, from={}", person, from);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(person.getEmail());
        message.setSubject("[CHECK YOUR ACCOUT] Hello, welcome to Eloware!!!");
        message.setText(buildEmailMessage(person));
        logger.info("m=sendSimpleMessage stage=finish message={}", message);
        emailSender.send(message);
    }

    private static String buildEmailMessage(Person personEntity) {
        StringBuilder builder;
        builder = new StringBuilder();
        builder.append("Click here to confirm your account: ");
        builder.append("http://localhost:8080/api/v1/persons/confirmAccount?confirmationToken=");
        builder.append(personEntity.getConfirmationToken().toString());
        return builder.toString();
    }

}
