package com.springboot.mywebapp.repository;

import com.springboot.mywebapp.modal.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
