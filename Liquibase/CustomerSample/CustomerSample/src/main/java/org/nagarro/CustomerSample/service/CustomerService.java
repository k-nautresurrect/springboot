package org.nagarro.CustomerSample.service;

import org.nagarro.samplelib.entity.Customer;
import org.nagarro.samplelib.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerrepo;

	public void saveCustomer(Customer customer) {
		customerrepo.save(customer);

	}

}
