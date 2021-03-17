package com.example.service.employee;

import com.example.entity.Division;
import com.example.entity.EducationDegree;
import com.example.entity.Employee;
import com.example.entity.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable);

    Page<Employee> findByName(String name, Pageable pageable);

    Employee findById(Integer id);

    void save (Employee employee);

    void remove(Integer id);

    List<Position> findAllPosition();

    List<EducationDegree> findAllEducationDegree();

    List<Division> findAllDivision();
}
