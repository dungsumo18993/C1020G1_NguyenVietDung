package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping("/")
    public ModelAndView showList(){
        return new ModelAndView("list","bookList", bookService.findAll());
    }

    @GetMapping("/book/{id}/borrow")
    public String borrow(@PathVariable int id, Model model, RedirectAttributes redirect){
        Book book = bookService.findById(id);
        if (book.getAmount() > 0){
            book.setAmount(book.getAmount() - 1);
            bookService.save(book);
            redirect.addFlashAttribute("success", "Has successfully borrowed the book !!");
        } else {
            redirect.addFlashAttribute("success", "This book is over !!");
        }
        model.addAttribute("bookList", bookService.findAll());
        return "redirect:/";
    }

    @GetMapping("/book/return")
    public ModelAndView giveBack(){
        return new ModelAndView("borrow");
    }

    @PostMapping("/book/borrow")
    public String giveBackBook(@RequestParam String bookCode, Model model){
        Book book = bookService.findByCode(bookCode);
        if (book == null){
            model.addAttribute("message", "Not found !!");
            return "borrow";
        } else {
            book.setAmount(book.getAmount() + 1);
            bookService.save(book);
            model.addAttribute("message","Has successfully returned the book !!");
        }
        return "borrow";
    }
}
