package com.codegym.demojpa.models;

import com.codegym.demojpa.ultil.validate.UniqueEmail;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Nhập tên vô bạn ơi!!")
    private String name;

    @Min(value = 18,message = "Chưa đủ tuổi bạn ơi!!")
    @Max(value = 120, message = "Quá tuổi rồi ông/bà ơi!!")
    private int age;

    @ManyToOne
    @JoinColumn(name = "type_of_class_id")
    private TypeOfClass typeOfClass;

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public TypeOfClass getTypeOfClass() {
        return typeOfClass;
    }

    public void setTypeOfClass(TypeOfClass typeOfClass) {
        this.typeOfClass = typeOfClass;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
