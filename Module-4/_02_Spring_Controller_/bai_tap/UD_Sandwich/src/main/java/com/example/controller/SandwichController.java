package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class SandwichController {
    @GetMapping("/")
    public String choose(){
        return "index";
    }

    @RequestMapping("/save")
    public String save(@RequestParam String[] condiment, Model model) {
        model.addAttribute("condiment", Arrays.toString(condiment));
        return "index";
    }
}
