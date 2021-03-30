package com.example.repository.employee;

import com.example.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("select e from Employee e where concat(e.employeeName, e.employeeIdCard, e.employeeAddress, e.employeePhone) like %?1%")
    Page<Employee> findAllInput(String name, Pageable pageable);
}
