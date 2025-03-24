package com.example.Midterm.Services.Implements;

import com.example.Midterm.Models.Product;
import com.example.Midterm.Repositories.ProductRepository;
import com.example.Midterm.Services.Originals.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repository;

    @Override
    public Iterable<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Product findOne(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Product addOne(Product product) {
        return repository.save(product);
    }

    @Override
    public Product updateOne(Product product) {
        return repository.save(product);
    }

    @Override
    public void deleteOne(Long id) {
        repository.deleteById(id);
    }
}