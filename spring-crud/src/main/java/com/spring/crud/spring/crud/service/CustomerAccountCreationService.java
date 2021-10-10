package com.spring.crud.spring.crud.service;

import com.spring.crud.spring.crud.entity.Customer;
import com.spring.crud.spring.crud.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerAccountCreationService {
    @Autowired
    CustomerRepository customerRepository;


    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> viewCustomers() {
        return customerRepository.findAll();
    }

//    public Customer showCustomerByName(String name){
//        return customerRepository.findCustomerByName(name);
//    }

    public Optional<Customer> viewCustomerById(int id) {
        return customerRepository.findById(id);
    }

    public String removeCustomer(int id) throws Exception {
        Optional<Customer> fetchedCustomer = customerRepository.findById(id);
        if (!fetchedCustomer.isEmpty()) {
            customerRepository.deleteById(id);
            String message = "Customer " + id + " has been removed.";
            return message;
        }
        return "customer is not found with id= " + id;
    }

    public Customer updateCustomer(Customer customer){
       Customer existingCustomer =  customerRepository.findById(customer.getCustomerId()).orElse(null);
        existingCustomer.setCustomerName(customer.getCustomerName());
        existingCustomer.setCustomerAddress(customer.getCustomerAddress());
        existingCustomer.setCustomerMobile(customer.getCustomerMobile());
        existingCustomer.setCustomerEmail(customer.getCustomerEmail());
        return customerRepository.save(existingCustomer);

    }
}
