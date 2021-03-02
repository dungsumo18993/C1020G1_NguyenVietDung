package com.codegym.demojpa.controllers;

import com.codegym.demojpa.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/")
    public ModelAndView getHomePage(){
        System.out.println(studentService.findByName("Hung").toString());
        return new ModelAndView("home", "students", studentService.findAllStudent());
    }
}
