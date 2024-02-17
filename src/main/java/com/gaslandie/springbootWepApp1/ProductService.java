package com.gaslandie.springbootWepApp1;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityNotFoundException;

@Component
public class ProductService {
    @Autowired //spring va creer et gerer notre objet
    ProductDB db;
    
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    //recuperer tous les produits
    public List<Product> getAllProducts(){
        try {
            return db.findAll();
        } catch (Exception e) {
            //enregistrer le message d'erreur detaillé dans les journaux
            logger.error("Error when fetching data from database", e);

            //En cas d'erreur ,renvoyer une liste vide plutot que de propager l'exception
            return Collections.emptyList();
        }
        
    }
    //recuperer un produit
    public Product getProduct(int id) {
        try {
            return db.findById(id).orElse(null);
        } catch (Exception e) {
           logger.error("error when fetch data form database",e);
           return null;
        }
        
    }
    //ajouter un produit
    public void addProduct(Product p) {
        try {
            db.save(p);
        } catch (Exception e) {
            logger.error("error when adding a product to the database", e);
        }
       
    }
    //supprimer un produit
    public void deleteProduct(int id){
        try {
            db.deleteById(id);
        } catch (Exception e) {
            logger.error("error when trying to delete a product",e);
        }
        
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
