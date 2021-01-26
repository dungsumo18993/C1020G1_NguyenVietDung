package service.impl;

import bean.Student;
import repository.StudentRepository;
import repository.impl.StudentRepositoryImpl;
import repository.impl.StudentRepositoryImplOther;
import service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository = new StudentRepositoryImpl();

    @Override
    public void save(Student student) {

    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Integer id) {
        return studentRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {

    }
}
