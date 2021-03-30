package com.example.controller;

import com.example.entity.RentType;
import com.example.entity.Service;
import com.example.entity.ServiceType;
import com.example.service.rentType.impl.RentTypeServiceImpl;
import com.example.service.service.impl.ServiceServiceImpl;
import com.example.service.serviceType.impl.ServiceTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/services")
public class ServiceController {

    @Autowired
    private ServiceServiceImpl serviceService;

    @Autowired
    private ServiceTypeServiceImpl serviceTypeService;

    @ModelAttribute("serviceTypes")
    public List<ServiceType> findAllServiceType(){
        return serviceTypeService.findAll();
    }

    @Autowired
    private RentTypeServiceImpl rentTypeService;

    @ModelAttribute("rentTypes")
    public List<RentType> findAllRentType(){
        return rentTypeService.findAll();
    }

    @GetMapping("/list")
    public ModelAndView showList(@PageableDefault(size = 5)Pageable pageable){
        return new ModelAndView("/service/list", "serviceList", serviceService.findAll(pageable));
    }

    @GetMapping("/villa")
    public String creatVilla(Model model){
        model.addAttribute("service", new Service());
        return "/service/villa";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute Service service, BindingResult bindingResult, @RequestParam Integer idServiceType, Model model){
        if (!bindingResult.hasFieldErrors()) {
            service.setServiceType(serviceTypeService.findById(idServiceType));
            serviceService.save(service);
            model.addAttribute("message", "Add new Service successfully !!");
        }
        return "/service/villa";
    }

    @GetMapping("/house")
    public ModelAndView createHouse(){
        return new ModelAndView("/service/house","service", new Service());
    }

    @PostMapping("/saveHouse")
    public String saveHouse(@Valid @ModelAttribute Service service, BindingResult bindingResult, @RequestParam Integer idServiceType,
                             RedirectAttributes redirect){
        if (bindingResult.hasFieldErrors()){
            return "/service/house";
        } else {
            service.setServiceType(serviceTypeService.findById(idServiceType));
            serviceService.save(service);
            redirect.addFlashAttribute("message", "Add new Service successfully !!");
            return "redirect:/services/house";
        }
    }

    @GetMapping("/room")
    public ModelAndView createRoom(){
        return new ModelAndView("/service/room","service", new Service());
    }

    @PostMapping("/saveRoom")
    public String saveRoom(@Valid @ModelAttribute Service service, BindingResult bindingResult, @RequestParam Integer idServiceType,
                            RedirectAttributes redirect){
        if (bindingResult.hasFieldErrors()){
            return "/service/room";
        } else {
            service.setServiceType(serviceTypeService.findById(idServiceType));
            serviceService.save(service);
            redirect.addFlashAttribute("message", "Add new Service successfully !!");
            return "redirect:/services/room";
        }
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("service", serviceService.findById(id));
        return "service/edit";
    }

    @PostMapping("/update")
    public String update(Service service, Model model){
        serviceService.save(service);
        model.addAttribute("message", "Update Service successfully !!");
        return "service/edit";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id, Model model){
        serviceService.remove(id);
        model.addAttribute("message", "Deleted successfully !!");
        return "contract/active";
    }
}
