package com.example.com.controller;

import com.example.com.model.Blog;
import com.example.com.model.Category;
import com.example.com.service.BlogService;
import com.example.com.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories(){
        return categoryService.findAll();
    }

    //-------------------Retrieve All Blog--------------------------------------------------------

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Page<Blog>> listAllBlog(Pageable pageable){
        Page<Blog> blogs = blogService.findAllBlog(pageable);
        if (blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/blog/create")
    public String create(Model model){

        model.addAttribute("blog", new Blog());
//        model.addAttribute("date", date);
        return "create";
    }
    @PostMapping("/blog/save")
    public String save(Blog blog, RedirectAttributes redirect){
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date today = Calendar.getInstance().getTime();
        String date = df.format(today);
        blog.setDateCreate(date);
        blogService.save(blog);
        redirect.addFlashAttribute("message","Add new blog successfully !!");
        return "redirect:/";
    }

    @GetMapping("/blog/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("blog", blogService.findById(id));
        return "edit";
    }
    @PostMapping("/blog/update")
    public String update(Blog blog){
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date today = Calendar.getInstance().getTime();
        String date = df.format(today);
        blog.setDateCreate(date);
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
        redirect.addFlashAttribute("message", "Removed blog successfully !!");
        return "redirect:/";
    }

    //----------------------View Blog---------------------------------------

    @RequestMapping(value = "/blog/{id}/view", method = RequestMethod.GET)
    public ResponseEntity<Blog> showBlog(@PathVariable int id){
        Blog blog = blogService.findById(id);
        if (blog == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

}
