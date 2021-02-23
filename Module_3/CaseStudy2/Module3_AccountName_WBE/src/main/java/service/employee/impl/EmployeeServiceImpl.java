package service.employee.impl;

import model.Employee;
import repository.EmployeeRepository;
import repository.impl.EmployeeRepositoryImpl;
import service.employee.EmployeeService;
import service.validate.Validate;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
    @Override
    public List<Employee> findAllEmployee() {
        return employeeRepository.findAllEmployee();
    }

    @Override
    public Employee findEmployee(int id) {
        return employeeRepository.findEmployee(id);
    }

    @Override
    public List<Employee> findEmployee(String name) {
        return employeeRepository.findEmployee(name);
    }

    @Override
    public String insertEmployee(Employee employee) {
        String idCard = employee.getIdCard();
        String phone = employee.getPhone();
        String email = employee.getEmail();

        if(!Validate.idCardCheck(idCard)){
            return "ID Card incorrect format !!";
        } else
        if (!Validate.phoneCheck(phone)){
            return "Phone is not in the correct format !!";
        } else
        if (!Validate.emailCheck(email)){
            return "Email is not in the correct format !!";
        } else {
            employeeRepository.insertEmployee(employee);
            return "OK";
        }
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return employeeRepository.updateEmployee(employee);
    }

    @Override
    public boolean deleteEmployee(int id) {
        return employeeRepository.deleteEmployee(id);
    }
}
