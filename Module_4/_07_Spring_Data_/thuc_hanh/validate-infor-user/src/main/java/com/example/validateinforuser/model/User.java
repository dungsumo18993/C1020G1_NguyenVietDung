package com.example.validateinforuser.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User {
    @NotEmpty(message = "Tên không được để trống !!")
    @Size(min=2, max=30, message = "Tên không hợp lệ !!")
    private String name;

    @Min(value = 18, message = "Chưa đủ tuổi bạn êii !!")
    private int age;

    public User() {
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
}
