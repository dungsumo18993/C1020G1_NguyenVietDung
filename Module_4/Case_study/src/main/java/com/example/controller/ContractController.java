package com.example.controller;

import com.example.entity.Contract;
import com.example.entity.Customer;
import com.example.entity.Employee;
import com.example.entity.Service;
import com.example.service.contract.ContractService;
import com.example.service.customer.CustomerService;
import com.example.service.employee.EmployeeService;
import com.example.service.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @Autowired
    private EmployeeService employeeService;
    @ModelAttribute("employees")
    private Page<Employee> findAllEmployee(Pageable pageable){
        return employeeService.findAll(pageable);
    }

    @Autowired
    private CustomerService customerService;
    @ModelAttribute("customers")
    private Page<Customer> findAllCustomer(Pageable pageable){
        return customerService.findAllCustomer(pageable);
    }

    @Autowired
    private ServiceService serviceService;
    @ModelAttribute("services")
    private Page<Service> findAllService(Pageable pageable){
        return serviceService.findAll(pageable);
    }

    @GetMapping("/")
    public ModelAndView showList(Pageable pageable){
        return new ModelAndView("/contract/list", "contracts", contractService.findAll(pageable));
    }

    @GetMapping("/create")
    public ModelAndView create(){
        return new ModelAndView("/contract/create", "contract", new Contract());
    }

    @PostMapping("/save")
    public String save(Contract contract, RedirectAttributes redirect){
        contractService.save(contract);
        redirect.addFlashAttribute("message", "Add new Contract successfully !!");
        return "redirect:/contract/";
    }
}
