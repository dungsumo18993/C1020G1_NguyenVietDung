package repository;

import model.Employee;

import java.util.List;

public interface EmployeeRepository {

    public List<Employee> findAllEmployee();

    public Employee findEmployee(int id);

    public void insertEmployee(Employee employee);

    public boolean updateEmployee(Employee employee);

    public boolean deleteEmployee(int id);
}