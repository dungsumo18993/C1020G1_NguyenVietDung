package com.example.repository;

import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends PagingAndSortingRepository<Blog, Integer> {
    Page<Blog> findAllByNameContaining (String name, Pageable pageable);
    Page<Blog> findBlogByOrderByDateCreateAsc(Pageable pageable);
}
