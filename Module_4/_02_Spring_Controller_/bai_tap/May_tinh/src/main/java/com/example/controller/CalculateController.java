package com.example.controller;

import com.example.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculateController {
    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/")
    public String calculate(){
        return "index";
    }

    @PostMapping("/calculate")
    public String calculator(@RequestParam double number1, @RequestParam double number2, @RequestParam String cal, Model model){
        double result = calculatorService.operator(number1,number2,cal);
        model.addAttribute("result", result);
        model.addAttribute("cal", cal);
        return "index";
    }
}
