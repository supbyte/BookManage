package com.lmw.controller;

import com.lmw.entity.Borrow;
import com.lmw.service.BookService;
import com.lmw.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BorrowController {

    @Resource
    BookService bookService;
    @Resource
    StudentService studentService;

    @GetMapping({"/borrow", "/"})
    public String borrow(Model model) {
        //通过Security上下文读取当前用户信息
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("nickname", user.getUsername());
        model.addAttribute("borrow_list", bookService.getBorrowList());
        model.addAttribute("book_count", bookService.getBookList().size());
        model.addAttribute("student_count", studentService.getStudentList().size());
        return "borrow";
    }

    @GetMapping("/add-borrow")
    public String addBorrow(Model model) {
        //通过Security上下文读取当前用户信息
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("nickname", user.getUsername());
        model.addAttribute("book_list", bookService.getActiveBookList());
        model.addAttribute("student_list", studentService.getStudentList());
        return "add-borrow";
    }

    @PostMapping("/add-borrow")
    public String addBorrow(Borrow borrow) {
        bookService.addBorrow(borrow);
        return "redirect:/borrow";
    }

    @GetMapping("/return-book")
    public String returnBook(int id) {
        bookService.returnBook(id);
        return "redirect:/borrow";
    }
}
