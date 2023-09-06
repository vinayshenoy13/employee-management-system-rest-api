package com.employee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.models.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{

}
