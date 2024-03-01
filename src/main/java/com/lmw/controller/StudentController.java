package com.lmw.controller;

import com.lmw.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

    @Resource
    StudentService studentService;

    @GetMapping("/student")
    public String student(Model model) {
        //通过Security上下文读取当前用户信息
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("nickname", user.getUsername());
        model.addAttribute("student_list", studentService.getStudentList());
        return "student";
    }

}
