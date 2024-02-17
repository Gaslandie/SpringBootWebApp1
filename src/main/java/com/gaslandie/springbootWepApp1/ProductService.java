package com.gaslandie.springbootWepApp1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductService {
    @Autowired //spring va creer et gerer notre objet
    ProductDB db;
    // public void addProduct(Product p){
    //     db.save(p);
    // }

    public List<Product> getAllProducts(){
        return db.findAll();
    }

    public Product getProduct(int id) {
        return db.findById(id).orElse(null);
    }

    public void addProduct(Product p) {
        // TODO Auto-generated method stub
        db.save(p);
    }

    // public Product getProduct(String name){
    //     for(Product p : products){
    //         if(p.getName().equals(name))
    //             return p;
    //     }
    //     return null;
    // }
}
