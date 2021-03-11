package com.example.com.controller;

import com.example.com.model.Blog;
import com.example.com.service.impl.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class BlogRestController {

    @Autowired
    private BlogServiceImpl blogService;

    @GetMapping("/blog-list")
    public ResponseEntity<Page<Blog>> getAllBlog(@PageableDefault(size = 3) Pageable pageable){
        Page<Blog> blogs = blogService.findAllBlog(pageable);
        if (blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<Blog>> search(@PageableDefault(size = 5) Pageable pageable, @RequestParam String search){
        Page<Blog> blogs = blogService.findAllByName(search, pageable);
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
}
