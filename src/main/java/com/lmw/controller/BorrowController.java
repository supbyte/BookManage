package com.lmw.controller;

import com.lmw.service.BookService;
import com.lmw.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BorrowController {

    @Resource
    BookService bookService;
    @Resource
    StudentService studentService;

    @GetMapping({"/borrow", "/"})
    public String borrow(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("nickname", user.getUsername());
        model.addAttribute("borrow_list", bookService.getBorrowList());
        model.addAttribute("book_count", bookService.getBookList().size());
        model.addAttribute("student_count", studentService.getStudentList().size());
        return "borrow";
    }
}
