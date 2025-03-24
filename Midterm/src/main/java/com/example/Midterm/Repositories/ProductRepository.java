package com.example.Midterm.Repositories;

import com.example.Midterm.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}