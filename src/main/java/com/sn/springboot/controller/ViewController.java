package com.sn.springboot.controller;

import com.sn.springboot.pojo.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

//@CrossOrigin
@Controller
public class ViewController {
    @GetMapping("/freemarker_book")
    public String freemarkerBookView(Model model) {
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            book.setName("Springboot---" + i);
            book.setPrice(100 + i);
            books.add(book);
        }
        model.addAttribute("books", books);
        return "freemarker_book";
    }

    @GetMapping("/thymeleaf_book")
    public String thymeleafBookView(Model model) {
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            book.setName("Springboot---" + i);
            book.setPrice(100 + i);
            books.add(book);
        }
        model.addAttribute("books", books);
        return "thymeleaf_book";
    }
}
