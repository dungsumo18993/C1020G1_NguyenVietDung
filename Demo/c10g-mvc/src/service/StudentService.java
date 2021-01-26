package service;

import bean.Student;

import java.util.List;

public interface StudentService {

    void save(Student student);
    List<Student> findAll();
    Student findById(Integer id);
    void deleteById(Integer id);
}
