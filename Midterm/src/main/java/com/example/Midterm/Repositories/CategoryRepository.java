package com.example.Midterm.Repositories;

import com.example.Midterm.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}