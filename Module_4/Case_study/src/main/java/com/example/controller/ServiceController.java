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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String save(Service service,@RequestParam Integer idServiceType, Model model){
        service.setServiceType(serviceTypeService.findById(idServiceType));
        serviceService.save(service);
        model.addAttribute("message", "Add new Service successfully !!");
        return "/service/villa";
    }

    @GetMapping("/house")
    public ModelAndView createHouse(){
        return new ModelAndView("/service/house","service", new Service());
    }

    @PostMapping("/saveHouse")
    public String saveHouse(Service service, @RequestParam Integer idServiceType, RedirectAttributes redirect){
        service.setServiceType(serviceTypeService.findById(idServiceType));
        serviceService.save(service);
        redirect.addFlashAttribute("message", "Add new Service successfully !!");
        return "redirect:/services/house";
    }

    @GetMapping("/room")
    public ModelAndView createRoom(){
        return new ModelAndView("/service/room","service", new Service());
    }

    @PostMapping("/saveRoom")
    public String saveRoom(Service service, @RequestParam Integer idServiceType, RedirectAttributes redirect){
        service.setServiceType(serviceTypeService.findById(idServiceType));
        serviceService.save(service);
        redirect.addFlashAttribute("message", "Add new Service successfully !!");
        return "redirect:/services/room";
    }
}
