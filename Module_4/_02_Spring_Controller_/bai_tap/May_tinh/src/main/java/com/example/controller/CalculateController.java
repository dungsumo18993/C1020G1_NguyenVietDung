package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculateController {

    @GetMapping("/")
    public String calculate(){
        return "index";
    }

    @PostMapping("/calculate")
    public String calculator(@RequestParam double number1, @RequestParam double number2, @RequestParam String cal, Model model){
        double result;
        switch (cal){
            case "Addition":
                 result = number1 + number2;
                break;
            case "Subtraction":
                result = number1 - number2;
                break;
            case "Multiplication":
                result = number1*number2;
                break;
            default:
                result = number1/number2;
        }
        model.addAttribute("result", result);
        model.addAttribute("cal", cal);
        return "index";
    }
}
