package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {

    @GetMapping("/")
    public String showForm(Model model){
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/")
    public String checkValidate(@ModelAttribute("user") User user, BindingResult bindingResult, Model model){
        new User().validate(user, bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "index";
        } else {
            model.addAttribute("phoneNumber", user.getPhoneNumber());
            return "result";
        }
    }
}
