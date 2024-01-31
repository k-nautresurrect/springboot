package org.nagarro.CustomerSample.controller;


import org.nagarro.CustomerSample.service.CustomerService;
import org.nagarro.samplelib.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
//@RequestMapping("/Customer")
public class CustomerController {
	@Autowired
	private CustomerService customerservice;

	@PostMapping("/customer")
	public Customer addCustomer(@RequestBody Customer customer) {
		customerservice.saveCustomer(customer);
		return customer;
	}

}
