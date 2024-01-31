package com.nagarro.trainning.CustomerMangement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.trainning.CustomerMangement.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
