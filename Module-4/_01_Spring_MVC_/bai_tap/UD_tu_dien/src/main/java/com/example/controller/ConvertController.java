package com.example.controller;

import com.example.service.ConvertService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {

    ConvertService convertService = new ConvertService();
    @GetMapping("/")
    public String convert(){
        return "index";
    }

    @GetMapping("/result")
    public String result(@RequestParam String vocabulary, Model model){
        String result = convertService.search(vocabulary);
        model.addAttribute("result",result);
        model.addAttribute("vocabulary", vocabulary);
        return "index";
    }
}
