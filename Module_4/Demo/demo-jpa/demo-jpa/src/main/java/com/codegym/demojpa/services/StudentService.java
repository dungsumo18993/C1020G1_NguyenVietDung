package com.codegym.demojpa.services;

import com.codegym.demojpa.models.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAllStudent();
    Student findById(int id);
    Student findByName(String name);
}
