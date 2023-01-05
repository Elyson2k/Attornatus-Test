package com.project.apiperson;

import com.project.apiperson.domain.entities.Address;
import com.project.apiperson.domain.entities.City;
import com.project.apiperson.domain.entities.Person;
import com.project.apiperson.repository.AddressRepository;
import com.project.apiperson.repository.CityRepository;
import com.project.apiperson.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class PersonApplication{

	public static void main(String[] args) {
		SpringApplication.run(PersonApplication.class, args);
	}
}
