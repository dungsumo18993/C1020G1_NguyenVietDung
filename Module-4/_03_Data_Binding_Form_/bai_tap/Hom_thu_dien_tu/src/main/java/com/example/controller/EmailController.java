package com.example.controller;

import com.example.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmailController {

    @GetMapping("/")
    public ModelAndView showForm(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("email", new Email());
        modelAndView.addObject("language", new String[]{"English","Vietnamese","Japanese","Chinese"});
        modelAndView.addObject("size", new String[]{"5","10","15","25","50","100"});
        return modelAndView;
    }

    @PostMapping("/addEmail")
    public String submit(@ModelAttribute("email") Email email, Model model){
        model.addAttribute("language", email.getLanguage());
        model.addAttribute("size", email.getSize());
        model.addAttribute("filter", email.getFilter());
        model.addAttribute("signature", email.getSignature());
        return "info";
    }
}
