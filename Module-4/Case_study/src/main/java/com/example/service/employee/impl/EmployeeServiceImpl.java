package com.example.service.employee.impl;

import com.example.entity.Division;
import com.example.entity.EducationDegree;
import com.example.entity.Employee;
import com.example.entity.Position;
import com.example.repository.employee.DivisionRepository;
import com.example.repository.employee.EducationDegreeRepository;
import com.example.repository.employee.EmployeeRepository;
import com.example.repository.employee.PositionRepository;
import com.example.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private EducationDegreeRepository educationDegreeRepository;

    @Autowired
    private DivisionRepository divisionRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Page<Employee> findAllInput(String name, Pageable pageable) {
        return employeeRepository.findAllInput(name, pageable);
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void remove(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Position> findAllPosition() {
        return positionRepository.findAll();
    }

    @Override
    public List<EducationDegree> findAllEducationDegree() {
        return educationDegreeRepository.findAll();
    }

    @Override
    public List<Division> findAllDivision() {
        return divisionRepository.findAll();
    }
}
