package com.example.com.service.impl;

import com.example.com.model.Blog;
import com.example.com.repository.BlogRepository;
import com.example.com.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Page<Blog> findAllByName(String name, Pageable pageable) {
        return blogRepository.findAllByNameContaining(name, pageable);
    }

    @Override
    public Page<Blog> findAllBlog(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
//        if (blog.getId() == 0){
//            Date now = new Date();
//            blog.setDateCreate((now.getYear()+1900)+(now.getMonth()+1)+now.getDate()+"");
//        }
        blogRepository.save(blog);
    }

    @Override
    public void remove(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findBlogByOrderByDateCreateAsc(Pageable pageable) {
        return blogRepository.findBlogByOrderByDateCreateAsc(pageable);
    }
}
