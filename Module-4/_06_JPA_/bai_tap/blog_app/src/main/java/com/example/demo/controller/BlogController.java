package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/")
    public String index(Model model){
        List<Blog> blogList = blogService.findAllBlog();
        model.addAttribute("blogList", blogList);
        return "index";
    }

    @GetMapping("/blog/create")
    public String create(Model model){
        model.addAttribute("blog", new Blog());
        return "create";
    }
    @PostMapping("/blog/save")
    public String save(Blog blog, RedirectAttributes redirect){
        blog.setId((int) (Math.random() * 10000));
        blogService.save(blog);
        redirect.addFlashAttribute("success","Add new blog successfully !!");
        return "redirect:/";
    }

    @GetMapping("/blog/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("blog", blogService.findById(id));
        return "edit";
    }
    @PostMapping("/blog/update")
    public String update(Blog blog){
        blogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("/blog/{id}/delete")
    public String delete(@PathVariable int id, Model model){
        model.addAttribute("blog", blogService.findById(id));
        return "delete";
    }
    @PostMapping("/blog/delete")
    public String delete(Blog blog, RedirectAttributes redirect){
        blogService.remove(blog.getId());
        redirect.addFlashAttribute("success", "Removed blog successfully !!");
        return "redirect:/";
    }

    @GetMapping("/blog/{id}/view")
    public String view(@PathVariable int id, Model model){
        model.addAttribute("blog", blogService.findById(id));
        return "view";
    }

}
