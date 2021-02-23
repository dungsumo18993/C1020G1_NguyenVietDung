package repository.impl;

import model.Employee;
import repository.EmployeeRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private BaseRepository baseRepository = new BaseRepository();

    private static final String SELECT_ALL_EMPLOYEE = "select e.employee_id, e.employee_name, e.employee_birthday, e.employee_id_card, e.employee_salary," +
            "e.employee_phone, e.employee_email, e.employee_address, e.username, `position`.position_name, education_degree.education_degree_name, division.division_name" +
            " from employee e" +
            " join `position` on e.position_id = `position`.position_id" +
            " join education_degree on e.education_degree_id = education_degree.education_degree_id" +
            " join division on e.division_id = division.division_id" +
            " order by employee_id";

    private static final String SELECT_EMPLOYEE_BY_ID = "select * from employee " +
            "where employee_id =?";

    private static final String SELECT_EMPLOYEE_BY_NAME = "select e.employee_id, e.employee_birthday, e.employee_id_card, e.employee_salary," +
            "e.employee_phone, e.employee_email, e.employee_address, e.username, `position`.position_name, education_degree.education_degree_name, division.division_name" +
            " from employee e" +
            " join `position` on e.position_id = `position`.position_id" +
            " join education_degree on e.education_degree_id = education_degree.education_degree_id" +
            " join division on e.division_id = division.division_id" +
            " where e.employee_name = ?";


    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO employee" +
            "(employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, " +
            "employee_email, employee_address, username, position_id, education_degree_id, division_id) VALUES " +
            " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String UPDATE_EMPLOYEE_SQL = "update employee " +
            "set employee_name = ?,employee_birthday= ?, employee_id_card =?, employee_salary =?," +
            "employee_phone =?, employee_email =?, employee_address =?, username =?, position_id =?, education_degree_id =?, division_id =?" +
            "where employee_id = ?;";

    private static final String DELETE_EMPLOYEE_SQL = "delete from employee " +
            "where employee_id = ?;";
    @Override
    public List<Employee> findAllEmployee() {
        List<Employee> employeeList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(SELECT_ALL_EMPLOYEE);

            ResultSet rs =preparedStatement.executeQuery();

            Employee employee = null;
            while (rs.next()){
                employee = new Employee();
                employee.setId(Integer.parseInt(rs.getString("employee_id")));
                employee.setName(rs.getString("employee_name"));
                employee.setDateOfBirth(rs.getString("employee_birthday"));
                employee.setIdCard(rs.getString("employee_id_card"));
                employee.setSalary(Double.parseDouble(rs.getString("employee_salary")));
                employee.setPhone(rs.getString("employee_phone"));
                employee.setEmail(rs.getString("employee_email"));
                employee.setAddress(rs.getString("employee_address"));
                employee.setUsername(rs.getString("username"));
                employee.setPosition(rs.getString("position_name"));
                employee.setEducationDegree(rs.getString("education_degree_name"));
                employee.setDivision(rs.getString("division_name"));

                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public Employee findEmployee(int id) {
        Employee employee = new Employee();

        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(SELECT_EMPLOYEE_BY_ID);
            preparedStatement.setInt(1,id);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()){
                employee.setName(rs.getString("employee_name"));
                employee.setDateOfBirth(rs.getString("employee_birthday"));
                employee.setIdCard(rs.getString("employee_id_card"));
                employee.setSalary(Double.parseDouble(rs.getString("employee_salary")));
                employee.setPhone(rs.getString("employee_phone"));
                employee.setEmail(rs.getString("employee_email"));
                employee.setAddress(rs.getString("employee_address"));
                employee.setUsername(rs.getString("username"));
                employee.setPosition(rs.getString("position_id"));
                employee.setEducationDegree(rs.getString("education_degree_id"));
                employee.setDivision(rs.getString("division_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> findEmployee(String name) {
        List<Employee> employeeList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(SELECT_EMPLOYEE_BY_NAME);
            preparedStatement.setString(1,name);

            ResultSet rs = preparedStatement.executeQuery();
            Employee employee = null;
            if (rs.next()){
                employee = new Employee();
                employee.setId(Integer.parseInt(rs.getString("employee_id")));
                employee.setDateOfBirth(rs.getString("employee_birthday"));
                employee.setIdCard(rs.getString("employee_id_card"));
                employee.setSalary(Double.parseDouble(rs.getString("employee_salary")));
                employee.setPhone(rs.getString("employee_phone"));
                employee.setEmail(rs.getString("employee_email"));
                employee.setAddress(rs.getString("employee_address"));
                employee.setUsername(rs.getString("username"));
                employee.setPosition(rs.getString("position_name"));
                employee.setEducationDegree(rs.getString("education_degree_name"));
                employee.setDivision(rs.getString("division_name"));

                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public void insertEmployee(Employee employee) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(INSERT_EMPLOYEE_SQL);
            preparedStatement.setString(1,employee.getName());
            preparedStatement.setString(2, employee.getDateOfBirth());
            preparedStatement.setString(3, employee.getIdCard());
            preparedStatement.setDouble(4, employee.getSalary());
            preparedStatement.setString(5, employee.getPhone());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, employee.getAddress());
            preparedStatement.setString(8, employee.getUsername());
            preparedStatement.setString(9, employee.getPosition());
            preparedStatement.setString(10, employee.getEducationDegree());
            preparedStatement.setString(11, employee.getDivision());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean updateEmployee(Employee employee) {
        boolean rowUpdate = false;

        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(UPDATE_EMPLOYEE_SQL);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getDateOfBirth());
            preparedStatement.setString(3, employee.getIdCard());
            preparedStatement.setDouble(4, employee.getSalary());
            preparedStatement.setString(5, employee.getPhone());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, employee.getAddress());
            preparedStatement.setString(8, employee.getUsername());
            preparedStatement.setString(9, employee.getPosition());
            preparedStatement.setString(10, employee.getEducationDegree());
            preparedStatement.setString(11, employee.getDivision());
            preparedStatement.setInt(12, employee.getId());

            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }

    @Override
    public boolean deleteEmployee(int id) {
        boolean rowDelete = false;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(DELETE_EMPLOYEE_SQL);
            preparedStatement.setInt(1,id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelete;
    }
}
