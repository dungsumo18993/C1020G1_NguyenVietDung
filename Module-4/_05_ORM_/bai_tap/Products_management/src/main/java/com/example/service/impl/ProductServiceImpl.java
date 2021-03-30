package com.example.service.impl;

import com.example.model.Product;
import com.example.repository.ProductsRepo;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductsRepo productsRepo;

    @Override
    public List<Product> findAll() {
        return productsRepo.findAll();
    }

    @Override
    public void save(Product product) {
        productsRepo.save(product);
    }

    @Override
    public Product findById(Integer id) {
        return productsRepo.findById(id);
    }

    @Override
    public void remove(Integer id) {
        productsRepo.remove(id);
    }
}
