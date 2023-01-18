package com.furkanbulut.example.repository;

import com.furkanbulut.example.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,String> {
    Optional<Object> findByName(String name);
}
