package com.lmw.controller;

import com.lmw.entity.Book;
import com.lmw.service.BookService;
import jakarta.annotation.Resource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class BookController {

    @Resource
    BookService bookService;

    @GetMapping("/books")
    public String books(Model model) {
        //通过Security上下文读取当前用户信息
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("nickname", user.getUsername());
        model.addAttribute("book_list", bookService.getBookList().keySet());
        model.addAttribute("book_list_status", new ArrayList<>(bookService.getBookList().values()));
        return "books";
    }

    @GetMapping("/add-book")
    public String addBook(Model model) {
        //通过Security上下文读取当前用户信息
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("nickname", user.getUsername());
        return "add-book";
    }

    @PostMapping("/add-book")
    public String addBook(Book book) {
        bookService.addBook(book);
        return "redirect:/books";
    }

    @GetMapping("/delete-book")
    public String deleteBook(int id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}
