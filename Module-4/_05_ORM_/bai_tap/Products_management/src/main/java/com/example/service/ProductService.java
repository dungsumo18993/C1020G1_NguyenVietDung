package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(Integer id);

    void remove(Integer id);
}
