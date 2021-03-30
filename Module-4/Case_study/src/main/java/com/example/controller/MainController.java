package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String welcomePage(){
        return "home";
    }

    @GetMapping("/403")
    public String error(){
        return "/error403";
    }
}
