package com.project.apiperson.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig {

    private final Logger logger = LoggerFactory.getLogger(MailConfig.class);
    public static final String OUTLOOK_OFFICE = "outlook.office365.com";
    @Value("${email.username}")
    private String username;

    @Value("${email.password}")
    private String password;

    @Bean
    public JavaMailSender getJavaMailSender() {
        logger.info("m=getJavaMailSender stage=init username={}, password={}", username, password);
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(OUTLOOK_OFFICE);
        mailSender.setPort(587);
        mailSender.setUsername(username);
        mailSender.setPassword(password);
        setMailSenderProperties(mailSender);
        logger.info("m=getJavaMailSender stage=finish");
        return mailSender;
    }

    private static void setMailSenderProperties(JavaMailSenderImpl mailSender) {
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "outlook.office365.com");
        props.put("mail.smtp.port", "587");
    }
}
