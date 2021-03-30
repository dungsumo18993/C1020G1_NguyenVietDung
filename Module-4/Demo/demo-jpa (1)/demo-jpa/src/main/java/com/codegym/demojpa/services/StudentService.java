package com.codegym.demojpa.services;

import com.codegym.demojpa.models.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {
    Page<Student> findAllStudent(Pageable pageable);
    Student findById(int id);
    Student findByName(String name);
    void save(Student student);
}
