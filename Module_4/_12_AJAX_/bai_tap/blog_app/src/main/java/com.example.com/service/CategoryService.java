package com.example.com.service;

import com.example.com.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    Page<Category> findAll(Pageable pageable);

    Iterable<Category> findAll();

    Category findById(int id);

    void save(Category category);

    void remove(int id);
}
