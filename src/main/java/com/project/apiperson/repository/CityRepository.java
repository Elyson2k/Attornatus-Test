package com.project.apiperson.repository;

import com.project.apiperson.entities.Address;
import com.project.apiperson.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {
}
