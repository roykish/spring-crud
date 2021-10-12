package com.spring.crud.spring.crud.service;

import com.spring.crud.spring.crud.entity.Customer;
import com.spring.crud.spring.crud.entity.Product;
import com.spring.crud.spring.crud.repository.CustomerRepository;
import com.spring.crud.spring.crud.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Service
public class OrderRequest {

    //    @Autowired
//    private Customer customer;
//    @Autowired
//    private Product product;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CustomerRepository customerRepository;


    public Customer Order(Customer customer) {
        Product product = productRepository.findById(customer.getProduct().getProductId()).orElse(null);
        if (product != null) {
            customer.setProduct(product);
        }
        return customerRepository.save(customer);
    }
}
