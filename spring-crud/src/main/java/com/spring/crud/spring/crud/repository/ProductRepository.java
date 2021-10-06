package com.spring.crud.spring.crud.repository;

import com.spring.crud.spring.crud.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
   //@Query(value = "SELECT product_name FROM test.product WHERE product_name = :name",nativeQuery = true)
   Product findByProductName(String name);
}
