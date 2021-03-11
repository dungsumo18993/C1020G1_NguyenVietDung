package com.example.com.controller;

import com.example.com.model.Category;
import com.example.com.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //-------------------Retrieve All Category--------------------------------------------------------

    @RequestMapping(value = "/categorys", method = RequestMethod.GET)
    public ResponseEntity<Page<Category>> findAllCategory(Pageable pageable){
        Page<Category> categories = categoryService.findAll(pageable);
        if (categories.isEmpty()){
            return new ResponseEntity<Page<Category>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Page<Category>>(categories, HttpStatus.OK);
    }

    @GetMapping("/category/create")
    public ModelAndView createForm(){
        return new ModelAndView("/category/create","category", new Category());
    }
    @PostMapping("/category/save")
    public String save(Category category, RedirectAttributes redirect){
        categoryService.save(category);
        redirect.addFlashAttribute("message", "Add new category successfully !!");
        return "redirect:/categorys";
    }

    @GetMapping("/category/{id}/edit")
    public ModelAndView edit(@PathVariable int id){
        return new ModelAndView("/category/edit","category", categoryService.findById(id));
    }
    @PostMapping("/category/update")
    public String update(Category category){
        categoryService.save(category);
        return "redirect:/categorys";
    }

    @GetMapping("/category/{id}/delete")
    public ModelAndView delete(@PathVariable int id){
        return new ModelAndView("/category/delete","category", categoryService.findById(id));
    }
    @PostMapping("/category/delete")
    public String delete(Category category, RedirectAttributes redirect){
        categoryService.remove(category.getId());
        redirect.addFlashAttribute("message", "Removed blog successfully !!");
        return "redirect:/categorys";
    }


}
