package com.gaslandie.springbootWepApp1;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class ProductController {
    @Autowired
    ProductService service;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }
    
}
