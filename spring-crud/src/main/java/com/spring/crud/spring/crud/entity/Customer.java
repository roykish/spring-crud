package com.spring.crud.spring.crud.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;
    private String customerName;
    private String customerAddress;
    private int customerMobile;
    private String customerEmail;
    @OneToOne(targetEntity = Product.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "productId_as_fk")
    private Product product;
}
