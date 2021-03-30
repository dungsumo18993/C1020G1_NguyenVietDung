package com.example.demo.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Component
public class User implements Validator {
    @NotEmpty(message = "First name not empty !!")
    @Size(min = 5,max = 45, message = "First Name not suitable !!")
    private String firstName;

    @NotEmpty(message = "Last name not empty !!")
    @Size(min = 5,max = 45, message = "Last Name not suitable !!")
    private String lastName;

    @Min(value = 18,message = "Age is not suitable !!")
    private String age;

    private String phoneNumber;

    @Pattern(regexp = "([\\w]+@[a-z]+.[a-z]+)",message = "Email malformed !!")
    private String email;

    public User() {
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        String number = user.getPhoneNumber();
        ValidationUtils.rejectIfEmpty(errors, "phoneNumber", "number.empty");
        if (number.length()>11 || number.length()<10){
            errors.rejectValue("phoneNumber", "number.length");
        }
        if (!number.startsWith("0")){
            errors.rejectValue("phoneNumber", "number.startsWith");
        }
        if (!number.matches("(^$|[0-9]*$)")){
            errors.rejectValue("phoneNumber", "number.matches");
        }
    }
}
