package com.gaslandie.springbootWepApp1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//ProductDB qui est herite des methode de JpaRepository pour communiquer facilement et avec simplicité avec notre base de donnees
@Repository
public interface ProductDB extends JpaRepository<Product,Integer> {
}