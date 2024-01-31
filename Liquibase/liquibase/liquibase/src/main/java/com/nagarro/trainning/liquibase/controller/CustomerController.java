package com.nagarro.trainning.liquibase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.trainning.liquibase.entity.Customer;
import com.nagarro.trainning.liquibase.service.CustomerService;

@RestController
@RequestMapping("/Customer")
public class CustomerController {
	@Autowired
	private CustomerService customerservice;

	@PostMapping("/")
	public Customer addCustomer(@RequestBody Customer customer) {
		customerservice.saveCustomer(customer);
		return customer;
	}

	@GetMapping("/")

	public List<Customer> getCustomers() {
		return customerservice.findAllCustomers();

	}

}
