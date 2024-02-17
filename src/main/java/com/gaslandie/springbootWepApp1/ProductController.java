package com.gaslandie.springbootWepApp1;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
public class ProductController {
    @Autowired
    ProductService service;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public Product getProduct(@RequestParam int id) {
        return service.getProduct(id);
    }
    @PostMapping("/product")
    public void addProduct(@RequestBody Product p) {
        //TODO: process POST request
        service.addProduct(p);
    }
    
    

    
    
    
}
