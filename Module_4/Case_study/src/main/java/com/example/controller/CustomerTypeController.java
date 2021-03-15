package com.example.controller;

import com.example.service.customerType.impl.CustomerTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerTypeController {

    @Autowired
    private CustomerTypeServiceImpl customerTypeService;

    @GetMapping("/customerType-list")
    public ModelAndView showList(){
        return new ModelAndView("/customerType/list", "customerTypeList", customerTypeService.findAll());
    }
}
