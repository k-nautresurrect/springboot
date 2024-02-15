package com.nagarro.batch.config;

import com.nagarro.batch.domain.Customer;
import org.springframework.batch.item.ItemProcessor;


public class CustomerProcessor implements ItemProcessor<Customer,Customer> {


    @Override
    public Customer process(Customer customer) throws Exception {
        //logic here
        return customer;
    }
}
