package com.example.Midterm.Services.Originals;

import com.example.Midterm.Models.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    public Iterable<Product> findAll();
    public Product findOne(Long id);
    public Product addOne(Product product);
    public Product updateOne(Product product);
    public void deleteOne(Long id);
}