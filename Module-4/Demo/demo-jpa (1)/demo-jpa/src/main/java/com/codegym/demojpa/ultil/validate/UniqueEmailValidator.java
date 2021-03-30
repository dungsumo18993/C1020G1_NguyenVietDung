//package com.codegym.demojpa.ultil.validate;
//
//import com.codegym.demojpa.services.StudentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//
//
//@Component
//public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String>{
//
//    @Autowired
//    private StudentService studentService;
//
//    @Override
//    public boolean isValid(String value, ConstraintValidatorContext context) {
//        //Phần code kiểm tra validate
////        return value != null && !studentService.checkExistStudent(value);
//        return true;
//    }
//}