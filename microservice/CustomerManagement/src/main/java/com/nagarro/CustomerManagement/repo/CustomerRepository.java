package com.nagarro.CustomerManagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.CustomerManagement.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	Customer findByCustomerId(int id);
	Customer findByAccountNumber(String accountNumber);

}
