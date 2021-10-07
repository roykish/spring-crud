package com.spring.crud.spring.crud.service;

import com.spring.crud.spring.crud.entity.Customer;
import com.spring.crud.spring.crud.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CustomerAccountCreationService {
    @Autowired
    CustomerRepository customerRepository;
    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }
}
