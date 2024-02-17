package com.gaslandie.springbootWepApp1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityNotFoundException;

@Component
public class ProductService {
    @Autowired //spring va creer et gerer notre objet
    ProductDB db;
    // public void addProduct(Product p){
    //     db.save(p);
    // }
    //recuperer tous les produits
    public List<Product> getAllProducts(){
        return db.findAll();
    }
    //recuperer un produit
    public Product getProduct(int id) {
        return db.findById(id).orElse(null);
    }
    //ajouter un produit
    public void addProduct(Product p) {
        
        db.save(p);
    }
    //supprimer un produit
    public void deleteProduct(int id){
        db.deleteById(id);
    }
    //mettre à jour un produit
    public Product updateProduct(int id,Product updatedProduct){
        //recuperer le produit à mettre à jour
        Optional<Product> existingProduct = db.findById(id);

        //mettre à jour le produit
        if(existingProduct.isPresent()){
            Product productToUpdate = existingProduct.get();
            //mise à jour du produit
            productToUpdate.setName(updatedProduct.getName());
            productToUpdate.setPlace(updatedProduct.getPlace());
            productToUpdate.setType(updatedProduct.getType());
            productToUpdate.setWarranty(updatedProduct.getWarranty());

            //Enregistrer la mise à jour dans la base de données
            return db.save(productToUpdate);
        }else{//si le produit n'est pas trouvé
            throw new EntityNotFoundException("product with id "+id+" not found");
        }
    }
}
