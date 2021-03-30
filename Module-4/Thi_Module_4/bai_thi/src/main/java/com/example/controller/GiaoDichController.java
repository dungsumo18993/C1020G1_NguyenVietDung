package com.example.controller;

import com.example.entity.GiaoDich;
import com.example.entity.KhachHang;
import com.example.service.GiaoDichService;
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
import java.util.Optional;

@Controller
public class GiaoDichController {
    @Autowired
    private GiaoDichService giaoDichService;

    @ModelAttribute("danhSachKhachHang")
    public List<KhachHang> findAllCustomer(){
        return giaoDichService.findAllCustomer();
    }

    @GetMapping("/")
    public ModelAndView showList(@PageableDefault(size = 5)Pageable pageable){
        return new ModelAndView("list","giaoDichList", giaoDichService.findAll(pageable));
    }

    @GetMapping("/create")
    public ModelAndView create(){
        return new ModelAndView("create", "giaoDich", new GiaoDich());
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("giaoDich") GiaoDich giaoDich, BindingResult bindingResult, RedirectAttributes redirect){
        if (bindingResult.hasFieldErrors()){
            return "create";
        } else {
            giaoDichService.save(giaoDich);
            redirect.addFlashAttribute("message", "Thêm mới 1 giao dịch thành công !!");
            return "redirect:/";
        }
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model){
        model.addAttribute("giaoDich", giaoDichService.findById(id));
        return "view";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirect){
        giaoDichService.remove(id);
        redirect.addFlashAttribute("message", "Đã xóa giao dịch thành công !!");
        return "redirect:/";
    }

    @GetMapping("/search")
    public String search(@PageableDefault(size = 5) Pageable pageable, @RequestParam Optional<String> keyword, Model model){
        String keywordOld = "";
        if (!keyword.isPresent()) {
            model.addAttribute("giaoDichList", giaoDichService.findAll(pageable));
        } else {
            keywordOld = keyword.get();
            model.addAttribute("giaoDichList", giaoDichService.findAllInput(keywordOld, pageable));
        }
        return "list";
    }

}
