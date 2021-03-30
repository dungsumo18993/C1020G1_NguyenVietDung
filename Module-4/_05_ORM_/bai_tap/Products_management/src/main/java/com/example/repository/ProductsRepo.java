package com.example.repository;

import com.example.model.Product;

import java.util.List;

public interface ProductsRepo {
    List<Product> findAll();

    void save(Product product);

    Product findById(Integer id);

    void remove(Integer id);
}
