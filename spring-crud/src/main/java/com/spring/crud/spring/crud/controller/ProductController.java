package com.spring.crud.spring.crud.controller;

import com.spring.crud.spring.crud.entity.Product;
import com.spring.crud.spring.crud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {
        Product returnProduct = productService.saveProduct(product);
        return returnProduct;
    }

    //API for finding all products
    @GetMapping
    public List<Product> findAllProducts() {
        return productService.getProducts();
    }

    //API for finding product by id
    @GetMapping("/{id}")
    public Product findProductById(@PathVariable int id) {
        return productService.getProduct(id);
    }

    //API for finding product by name
    @GetMapping("findByName/{name}")
    public Product findProductByName(@PathVariable String name) {
        return productService.getProductByName(name);
    }

    //API for delete a product by product id
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) throws Exception {
        String deleteResult = productService.deleteProduct(id);
        return deleteResult;
    }

    //API for updating a product
    @PutMapping("/update")
    public String updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
        return "Updated a product!!" + product;
    }
}
