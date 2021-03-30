package com.codegym.demojpa.repositories;

import com.codegym.demojpa.models.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByName(String name);

    Page<Student> findAll(Pageable pageable);
}
