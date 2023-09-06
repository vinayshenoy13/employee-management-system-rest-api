package com.employee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.models.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

}
