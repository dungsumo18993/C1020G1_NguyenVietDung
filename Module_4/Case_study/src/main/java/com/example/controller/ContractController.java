package com.example.controller;

import com.example.entity.*;
import com.example.service.contract.ContractDetailService;
import com.example.service.contract.ContractService;
import com.example.service.customer.CustomerService;
import com.example.service.employee.EmployeeService;
import com.example.service.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    @Autowired
    private ContractDetailService contractDetailService;
    @ModelAttribute("attachServices")
    private List<AttachService> findAllAttach(){
        return contractDetailService.findAllAttach();
    }

    @GetMapping("/")
    public ModelAndView showList(@PageableDefault(size = 5) Pageable pageable){
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

    @GetMapping("/create-detail")
    public ModelAndView createDetail(){
        return new ModelAndView("/contract/detail", "contractDetail", new ContractDetail());
    }

    @PostMapping("/save-detail")
    public String saveDetail(ContractDetail contractDetail, RedirectAttributes redirect){
        contractDetailService.save(contractDetail);
        redirect.addFlashAttribute("message", "Add new Contract Detail successfully !!");
        return "redirect:/contract/create-detail";
    }

    @GetMapping("/active-list")
    public ModelAndView showListActive(@PageableDefault(size = 5) Pageable pageable){
        return new ModelAndView("contract/active", "contracts",
                contractService.findAllCustomerActive(LocalDate.now().toString(), pageable));
    }

    @GetMapping("/search-active")
    public String search(@PageableDefault(size = 5) Pageable pageable, @RequestParam Optional<String> keyword, Model model){
        String keywordOld = "";
        if (!keyword.isPresent()) {
            model.addAttribute("contracts", contractService.findAllCustomerActive(LocalDate.now().toString(), pageable));
            return "contract/active";
        } else {
            keywordOld = keyword.get();
            model.addAttribute("contracts", contractService.findAllInput(LocalDate.now().toString(), keywordOld, pageable));
            return "contract/active";
        }
    }
}
