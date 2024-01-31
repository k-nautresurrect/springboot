package com.nagarro.trainning.CustomerMangement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.trainning.CustomerMangement.entity.Account;
import com.nagarro.trainning.CustomerMangement.entity.Customer;
import com.nagarro.trainning.CustomerMangement.repository.AccountRepository;
import com.nagarro.trainning.CustomerMangement.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerrepo;

	public void saveCustomer(Customer customer) {
		customerrepo.save(customer);

	}

	public void deleteCustomer(int id) {
		Customer customer = customerrepo.getOne(id);
		customerrepo.delete(customer);

	}

	public List<Customer> findAllCustomers() {
		List<Customer> allcustomers = customerrepo.findAll();

		return allcustomers;
	}

	public void updateCustomer(Customer customer) {
		customerrepo.save(customer);

	}

	public Customer getcustomer(int id) {

		return this.customerrepo.findById(id).get();

	}

}
