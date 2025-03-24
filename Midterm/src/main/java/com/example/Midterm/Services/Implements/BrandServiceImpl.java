package com.example.Midterm.Services.Implements;

import com.example.Midterm.Models.Brand;
import com.example.Midterm.Repositories.BrandRepository;
import com.example.Midterm.Services.Originals.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository repository;

    @Override
    public Iterable<Brand> findAll() {
        return repository.findAll();
    }

    @Override
    public Brand findOne(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Brand addOne(Brand brand) {
        return repository.save(brand);
    }

    @Override
    public Brand updateOne(Brand brand) {
        return repository.save(brand);
    }

    @Override
    public void deleteOne(Long id) {
        repository.deleteById(id);
    }
}