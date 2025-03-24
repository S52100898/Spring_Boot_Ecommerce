package com.example.Midterm.Services.Originals;

import com.example.Midterm.Models.Category;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {
    public Iterable<Category> findAll();
    public Category findOne(Long id);
    public Category addOne(Category category);
    public Category updateOne(Category category);
    public void deleteOne(Long id);
}