package com.spring.crud.spring.crud.controller;

import com.spring.crud.spring.crud.entity.Customer;
import com.spring.crud.spring.crud.service.CustomerAccountCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class customerController {
    @Autowired
    CustomerAccountCreationService customerAccountCreationService;

    @PostMapping("/add")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerAccountCreationService.saveCustomer(customer);

    }

    @GetMapping("/displayAll")
    public List<Customer> displayAllCustomer() {
        return customerAccountCreationService.viewCustomers();
    }

//    @GetMapping("searchByCustomerName/{name}")
//    public Customer displayCustomerByName(@PathVariable String name){
//        return customerAccountCreationService.showCustomerByName(name);
//    }
    @GetMapping("/customerId/{id}")
    public Optional<Customer> displayCustomerById(@PathVariable int id) {
        return customerAccountCreationService.viewCustomerById(id);
    }

    @DeleteMapping("/customerRemove/{id}")
    public String removeCustomer(@PathVariable int id) throws Exception {
        String deleteMsg = customerAccountCreationService.removeCustomer(id);
        return deleteMsg;
    }
    @PutMapping("/updateCustomer")
    public String UpdateExistingCustomer(@RequestBody Customer customer){
        customerAccountCreationService.updateCustomer(customer);
        return "Updated a Customer";
    }


}
