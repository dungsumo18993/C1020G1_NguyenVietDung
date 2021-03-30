package com.example.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class EducationDegree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "education_degree_id")
    private Integer educationDegreeId;

    @Column(name = "education_degree_name")
    private String educationDegreeName;

    //------------------ Tạo mối quan hệ --------------------
    @OneToMany(mappedBy = "educationDegree")
    private Set<Employee> employeeSet;
    //-------------------------------------------------------


    public EducationDegree() {
    }

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }

    public Integer getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(Integer educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public String getEducationDegreeName() {
        return educationDegreeName;
    }

    public void setEducationDegreeName(String educationDegreeName) {
        this.educationDegreeName = educationDegreeName;
    }
}
