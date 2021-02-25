package com.example.service.Impl;

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
    public Product findById(int id) {
        return productsRepo.findById(id);
    }

    @Override
    public void update(int id, Product product) {
        productsRepo.update(id, product);
    }

    @Override
    public void remove(int id) {
        productsRepo.remove(id);
    }
}
