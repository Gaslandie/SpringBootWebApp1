package com.gaslandie.springbootWepApp1;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
public class ProductController {
    @Autowired
    ProductService service;

    //requete recuperer tous les produits
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }
    //requete recuperer un produit
    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable int id) {
        return service.getProduct(id);
    }
    //requete ajouter un produit
    @PostMapping("/product")
    public void addProduct(@RequestBody Product p) {
        service.addProduct(p);
    }
    //requete supprimer un produit
    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        service.deleteProduct(id);
        return ResponseEntity.ok("Product with id:"+id+" has been deleted");
    }
    //requete pour mettre à jour un produit
    @PutMapping("product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product updatedProduct) {
        Product updatedProductResult = service.updateProduct(id, updatedProduct);
        
        return ResponseEntity.ok(updatedProductResult);
    }
}
