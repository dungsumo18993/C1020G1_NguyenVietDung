package com.example.demo.service;

import com.example.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ProductService {
    Page<Product> findAllProduct(Pageable pageable);

    Product findById(Integer id);

    void save(Product product);

    void remove(Integer id);
}
