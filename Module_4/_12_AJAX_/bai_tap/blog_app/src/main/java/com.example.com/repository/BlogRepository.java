package com.example.com.repository;

import com.example.com.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findAllByNameContaining (String name, Pageable pageable);
    Page<Blog> findBlogByOrderByDateCreateAsc(Pageable pageable);
}
