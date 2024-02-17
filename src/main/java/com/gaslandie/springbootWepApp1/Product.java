package com.gaslandie.springbootWepApp1;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


//notre entité qui a pour equivalent la table products de notre base de données, à chaque objet on fait correspondre une row
@Entity
@Table(name = "products")
public class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincrementation
    private int id;
    private String name;
    private String type;
    private String place;
    private int warranty;
    

    public Product(){}


    public Product(String name, String type, String place, int warranty) {
        this.name = name;
        this.type = type;
        this.place = place;
        this.warranty = warranty;
    }

    
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    public String getPlace() {
        return place;
    }


    public void setPlace(String place) {
        this.place = place;
    }


    public int getWarranty() {
        return warranty;
    }


    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

}
