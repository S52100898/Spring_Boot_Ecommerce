package com.example.Midterm.Services.Originals;

import com.example.Midterm.Models.Brand;
import org.springframework.stereotype.Service;

@Service
public interface BrandService {
    public Iterable<Brand> findAll();
    public Brand findOne(Long id);
    public Brand addOne(Brand brand);
    public Brand updateOne(Brand brand);
    public void deleteOne(Long id);
}