package com.spring.crud.spring.crud.repository;

import com.spring.crud.spring.crud.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
//    Customer findCustomerByName(String name);
}
