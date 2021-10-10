package com.spring.crud.spring.crud.service;

import com.spring.crud.spring.crud.entity.Product;
import com.spring.crud.spring.crud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    //service to Post a single product to database
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    //service to Post a list of products to database
    public List<Product> saveAllProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

    //service to Get the list of products from database to clint
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    //service to Get a single product by product id
    public Product getProduct(int id) {
        return productRepository.findById(id).orElse(null);
    }

    //service to Get a single product by product name
    public Product getProductByName(String name) {
        return productRepository.findByProductName(name);
    }

    //service to delete a product by product id.
    public String deleteProduct(int id) throws Exception {
        Optional<Product> p = productRepository.findById(id);
        System.out.println("p.isEmpty() = " + p.isEmpty());
        if (!p.isEmpty()) {
            productRepository.deleteById(id);
            return "product deleted. id=" + id;
        }
        return "product not found with id=" + id;
    }

    //service to update a product on database
    public Product updateProduct(Product product) {
        //first catch the product by that products id
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);
//        as there is no Update() method in JPA, we need to get the new product ,
//         and then set that to the previously existed product.
        existingProduct.setProductName(product.getProductName());
        existingProduct.setProductQuantity(product.getProductQuantity());
        existingProduct.setProductPrice(product.getProductPrice());
        //then return the new updated product
        return productRepository.save(existingProduct);
    }

}
