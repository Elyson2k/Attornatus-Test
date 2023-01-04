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
public class PersonApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(PersonApplication.class, args);
	}


	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private CityRepository cityRepository;

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Person p1 = new Person(null, "Elyson", "Elyson@Gmail.com","000.000.000-01", sdf.parse("25/02/2003"));
		City c1 = new City(null, "Baraúna");
		Address ad1 = new Address(null, "Rua São Francisco", "59695-000", 5, p1, c1);

		personRepository.saveAll(Arrays.asList(p1));
		cityRepository.saveAll(Arrays.asList(c1));
		addressRepository.saveAll(Arrays.asList(ad1));
	}

}
