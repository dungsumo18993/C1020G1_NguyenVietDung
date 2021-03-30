package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

    @GetMapping("/")
    public String goListBook() {
        return "list_book";
    }

    @GetMapping("/borrowBook")
    public String borrowBook(@RequestParam("id") Integer bookId) {
        return "ok";
    }

}
