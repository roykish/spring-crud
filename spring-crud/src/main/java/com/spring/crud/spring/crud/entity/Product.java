package com.spring.crud.spring.crud.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;
    private String productName;
    private String productCategory;
    private int productQuantity;
    private double productPrice;
    @OneToOne(targetEntity = Customer.class, mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Customer customer;
}
