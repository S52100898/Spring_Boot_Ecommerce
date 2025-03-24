package com.example.Midterm.Services.Implements;

import com.example.Midterm.Models.Category;
import com.example.Midterm.Repositories.CategoryRepository;
import com.example.Midterm.Services.Originals.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository repository;

    @Override
    public Iterable<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public Category findOne(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Category addOne(Category category) {
        return repository.save(category);
    }

    @Override
    public Category updateOne(Category category) {
        return repository.save(category);
    }

    @Override
    public void deleteOne(Long id) {
        repository.deleteById(id);
    }
}