package com.project.apiperson.repository;

import com.project.apiperson.entities.Address;
import com.project.apiperson.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    Optional<Person> findByEmail(String email);
}
