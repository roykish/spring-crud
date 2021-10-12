package com.spring.crud.spring.crud.controller;

import com.spring.crud.spring.crud.entity.Customer;
import com.spring.crud.spring.crud.service.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderRequest orderRequest;

    @PostMapping("/placeOrder")
    public Customer placeOrder(@RequestBody Customer customer){
       return orderRequest.Order(customer);
    }
}
