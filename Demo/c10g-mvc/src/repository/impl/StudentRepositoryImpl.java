package repository.impl;

import bean.Student;
import repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StudentRepositoryImpl implements StudentRepository {

    private static Map<Integer, Student> studentMap = new TreeMap<>();

    static {
        studentMap.put(1, new Student(1, "Duong", "25/01/2021", 1, 4));
        studentMap.put(2, new Student(2, "Van Phuc", "26/01/2021", 0, 6));
        studentMap.put(3, new Student(3, "Luong", "27/01/2021", 0, 9));
    }

    @Override
    public void save(Student student) {

    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(studentMap.values());
    }

    @Override
    public Student findById(Integer id) {
        return studentMap.get(id);
    }

    @Override
    public void deleteById(Integer id) {

    }
}
