package com.nagarro.CustomerManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.google.common.base.Optional;
import com.nagarro.CustomerManagement.domain.Customer;
import com.nagarro.CustomerManagement.repo.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepo;
	@Autowired
	private WebClient.Builder webClientBuilder;
	@Value("${accountservice.url}")
	private String accountServiceUrl;

	public void saveCustomer(Customer customer) {
		customerRepo.save(customer);
	}

	public void deleteCustomer(String accountNumber) {
		webClientBuilder.build().delete().uri(accountServiceUrl + accountNumber).retrieve().bodyToMono(Void.class)
				.block();
		Customer customer = customerRepo.findByAccountNumber(accountNumber);
		customerRepo.delete(customer);
	}

	public List<Customer> findAllCustomers() {
		List<Customer> allcustomers = customerRepo.findAll();
		return allcustomers;
	}

	public Customer getCustomerByAccountNumber(String accountNumber) {
		return customerRepo.findByAccountNumber(accountNumber);
	}

	public Customer updateCustomer(int customerId, Customer updatedCustomer) {
		Customer existingCustomer = customerRepo.findByCustomerId(customerId);

		existingCustomer.setName(updatedCustomer.getName());
		existingCustomer.setContact(updatedCustomer.getContact());
		existingCustomer.setEmail(updatedCustomer.getEmail());

		return customerRepo.save(existingCustomer);

	}

	public Customer getCustomer(int id) {

		return this.customerRepo.findByCustomerId(id);

	}

}
