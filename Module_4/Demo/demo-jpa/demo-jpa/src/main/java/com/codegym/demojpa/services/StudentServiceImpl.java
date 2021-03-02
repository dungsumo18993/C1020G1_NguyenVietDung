package com.codegym.demojpa.services;

import com.codegym.demojpa.models.Student;
import com.codegym.demojpa.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> findAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student findByName(String name) {
        return studentRepository.findByName(name);
    }
}
