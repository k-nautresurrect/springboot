package com.nagarro.trainning.CustomerMangement.controller;

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

import com.nagarro.trainning.CustomerMangement.entity.Customer;
import com.nagarro.trainning.CustomerMangement.services.AccountService;
import com.nagarro.trainning.CustomerMangement.services.CustomerService;

@RestController
@RequestMapping("Customer")
public class CustomerController {
	@Autowired
	private CustomerService customerservice;

	@PostMapping("/")//use customer dto
	public Customer addCustomer(@RequestBody Customer customer) {
		customerservice.saveCustomer(customer);
		return customer;
	}

	@DeleteMapping("/{id}")
	public String deleteCustomer(@PathVariable int id) {

		customerservice.deleteCustomer(id);
		return "deleted";

	}

	@GetMapping("/")

	public List<Customer> getCustomers() {
		return customerservice.findAllCustomers();

	}

	@PutMapping("/")
	public Customer updateCustomer(Customer customer) {
		customerservice.updateCustomer(customer);
		return customer;
	}

	@GetMapping("/{customerid}")
	public Customer getcategory(@PathVariable("customerid") int customerid) {
		return this.customerservice.getcustomer(customerid);
	}

}
