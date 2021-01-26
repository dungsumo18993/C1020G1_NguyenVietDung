package repository;

import bean.Student;

import java.util.List;

public interface StudentRepository {

    void save(Student student);
    List<Student> findAll();
    Student findById(Integer id);
    void deleteById(Integer id);
}
