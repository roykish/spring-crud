package com.spring.crud.spring.crud.controller;


import com.spring.crud.spring.crud.entity.Customer;
import com.spring.crud.spring.crud.service.CustomerAccountCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class customerController {
    @Autowired
    CustomerAccountCreationService customerAccountCreationService;

    @PostMapping("/add")
    public Customer addCustomer(Customer customer){
        return customerAccountCreationService.saveCustomer(customer);
    }
}
