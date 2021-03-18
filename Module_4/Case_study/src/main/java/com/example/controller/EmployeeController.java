package com.example.controller;

import com.example.entity.Division;
import com.example.entity.EducationDegree;
import com.example.entity.Employee;
import com.example.entity.Position;
import com.example.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @ModelAttribute("positions")
    public List<Position> findAllPosition(){
        return employeeService.findAllPosition();
    }

    @ModelAttribute("educationDegrees")
    public List<EducationDegree> findAllEducationDegree(){
        return employeeService.findAllEducationDegree();
    }

    @ModelAttribute("divisions")
    public List<Division> findAllDivision(){
        return employeeService.findAllDivision();
    }

    @GetMapping("/")
    public ModelAndView showList(@PageableDefault(size = 5) Pageable pageable){
        return new ModelAndView("employee/list", "employees", employeeService.findAll(pageable));
    }

    @GetMapping("/create")
    public ModelAndView create(){
        return new ModelAndView("/employee/create", "employee", new Employee());
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute Employee employee, BindingResult bindingResult, RedirectAttributes redirect){
        if (bindingResult.hasFieldErrors()){
            return "/employee/create";
        } else {
            employeeService.save(employee);
            redirect.addFlashAttribute("message", "Add new Employee successfully !!");
            return "redirect:/employees/";
        }
    }

    @GetMapping("/{id}/edit")
    public ModelAndView edit(@PathVariable int id){
        return new ModelAndView("/employee/edit", "employee", employeeService.findById(id));
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirect){
        employeeService.remove(id);
        redirect.addFlashAttribute("message", "Deleted successfully !!");
        return "redirect:/employees/";
    }

    @GetMapping("/search")
    public ModelAndView search(@PageableDefault(size = 5) Pageable pageable, @RequestParam String name){
        return new ModelAndView("/employee/list", "employees", employeeService.findByName(name, pageable));
    }
}
