package com.project.apiperson.repository;

import com.project.apiperson.domain.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
