package com.codegym.demojpa.controllers;

import com.codegym.demojpa.models.Student;
import com.codegym.demojpa.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/")
    public ModelAndView getHomePage(@PageableDefault(size = 5) Pageable pageable){
        return new ModelAndView("home", "students", studentService.findAllStudent(pageable));
    }

    @GetMapping("/create")
    public ModelAndView getCreatePage(){
        return new ModelAndView("create", "student", new Student());
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute Student student){
        studentService.save(student);
        return "redirect:/";
    }
}
