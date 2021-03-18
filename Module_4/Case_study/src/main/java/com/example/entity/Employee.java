package com.example.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "employee_name")
    @Size(min = 5, max = 45, message = "Name not suitable !!")
    private String employeeName;

    @Column(name = "employee_birthday")
    @NotEmpty(message = "Not be empty !!")
    private String employeeBirthday;

    @Column(name = "employee_id_card")
    @Pattern(regexp = "(\\d{9})|(\\d{12})", message = "The ID number must be in the format XXXXXXXXX or XXXXXXXXXXXX !!")
    private String employeeIdCard;

    @Column(name = "employee_salary")
    @Min(1)
    private Double employeeSalary;

    @Column(name = "employee_phone")
    @Pattern(regexp = "(090|091|(84)+90|(84)+91)\\d{7}", message = "Phone number must be in the format 090xxxxxxx or" +
            " 091xxxxxxx or (84) + 90xxxxxxx or (84) + 91xxxxxxx !!")
    private String employeePhone;

    @Column(name = "employee_email")
    @Pattern(regexp = "([\\w]+@[a-z]+.[a-z]+)", message = "Email malformed !!")
    private String employeeEmail;

    @Column(name = "employee_address")
    @NotEmpty(message = "Not be empty !!")
    private String employeeAddress;

    //---------------------- Tạo mối quan hệ -----------------------
    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "position_id")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "education_degree_id", referencedColumnName = "education_degree_id")
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "division_id", referencedColumnName = "division_id")
    private Division division;

    @OneToOne
    @JoinColumn(name = "user_name", referencedColumnName = "user_name")
    private User user;

    @OneToMany(mappedBy = "employee")
    private Set<Contract> contractSet;
    //--------------------------------------------------------------


    public Employee() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Contract> getContractSet() {
        return contractSet;
    }

    public void setContractSet(Set<Contract> contractSet) {
        this.contractSet = contractSet;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public Double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }
}
