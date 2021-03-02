package com.example.demo.service;

import com.example.demo.model.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAllBlog();
    Blog findById(int id);
    void save(Blog blog);
    void remove(int id);
}
