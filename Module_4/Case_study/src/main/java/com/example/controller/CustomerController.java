package com.example.controller;

import com.example.entity.Customer;
import com.example.entity.CustomerType;
import com.example.service.customer.impl.CustomerServiceImpl;
import com.example.service.customerType.impl.CustomerTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private CustomerTypeServiceImpl customerTypeService;

    @ModelAttribute("customerTypes")
    public Iterable<CustomerType> findAllCustomerType(){
        return customerTypeService.findAll();
    }

    @GetMapping("/")
    public String showHome(){
        return "/home";
    }

    @GetMapping("/customer-list")
    public ModelAndView showList(@PageableDefault(size = 5)Pageable pageable){
        return new ModelAndView("/customer/list","customerList", customerService.findAllCustomer(pageable));
    }

    @GetMapping("/customer-create")
    public String create(Model model){
        model.addAttribute("customer", new Customer());
        return "/customer/create";
    }

    @PostMapping("/customer-save")
    public String save(Customer customer, RedirectAttributes redirect){
        customerService.save(customer);
        redirect.addFlashAttribute("message", "Add new Customer successfully !!");
        return "redirect:/customer-list";
    }

    @GetMapping("/customer/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("customer", customerService.findById(id));
        return "/customer/edit";
    }

    @PostMapping("/customer-update")
    public String update(Customer customer){
        customerService.save(customer);
        return "redirect:/customer-list";
    }

    @GetMapping("/customer-delete")
    public String delete(@RequestParam int id, RedirectAttributes redirect){
        customerService.remove(id);
        redirect.addFlashAttribute("message", "Deleted successfully !!");
        return "redirect:/customer-list";
    }

    @GetMapping("customer/{id}/view")
    public String view(@PathVariable int id, Model model){
        model.addAttribute("customer", customerService.findById(id));
        return "/customer/view";
    }

    @GetMapping("/customer-search")
    public String search(@PageableDefault(size = 5) Pageable pageable, @RequestParam String name, Model model){
        model.addAttribute("customerList", customerService.findByName(name, pageable));
        return "/customer/list";
    }
}
