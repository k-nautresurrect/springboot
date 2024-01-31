package com.nagarro.trainning.liquibase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.trainning.liquibase.entity.Customer;
import com.nagarro.trainning.liquibase.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerrepo;

	public void saveCustomer(Customer customer) {
		customerrepo.save(customer);

	}

	public List<Customer> findAllCustomers() {
		List<Customer> allcustomers = customerrepo.findAll();

		return allcustomers;
	}

}
