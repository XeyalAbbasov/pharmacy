package com.commerce.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.commerce.pharmacy.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
