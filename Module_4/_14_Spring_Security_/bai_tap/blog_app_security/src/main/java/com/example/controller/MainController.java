package com.example.controller;

import com.example.util.WebUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class MainController {

    @RequestMapping(value = { "/blog-list", "/welcome" }, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        model.addAttribute("message", "Welcome !! This is welcome page!");
        return "/blog/index";
    }

    @GetMapping("/403")
    public String error(){
        return "/error403";
    }
}
