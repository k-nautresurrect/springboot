package com.nagarro.CustomerManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.CustomerManagement.domain.Customer;
import com.nagarro.CustomerManagement.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/")
	public Customer addCustomer(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
		return customer;
	}

	@DeleteMapping("/{accountNumber}")
	public String deleteCustomer(@PathVariable String accountNumber) {
		customerService.deleteCustomer(accountNumber);
		return "deleted";

	}

	@GetMapping("/")
	public ResponseEntity<?> getCustomers(@RequestParam(required = false) String accountNumber) {
		if (accountNumber != null) {
			Customer customer = customerService.getCustomerByAccountNumber(accountNumber);
			if (customer != null) {
				return ResponseEntity.ok(customer);
			} else {
				return ResponseEntity.notFound().build();
			}
		} else {
			List<Customer> customers = customerService.findAllCustomers();
			return ResponseEntity.ok(customers);
		}
	}

	@PutMapping("/{customerId}")
	public ResponseEntity<Customer> updateCustomerById(@PathVariable int customerId,
			@RequestBody Customer updatedCustomer) {
		Customer updated = customerService.updateCustomer(customerId, updatedCustomer);
		if (updated != null) {
			return ResponseEntity.ok(updated);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/{customerId}")
	public Customer getCustomer(@PathVariable("customerId") int customerId) {
		return this.customerService.getCustomer(customerId);
	}

}
