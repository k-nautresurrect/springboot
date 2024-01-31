package com.nagarro.trainning.liquibase.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.trainning.liquibase.entity.Customer;



public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
