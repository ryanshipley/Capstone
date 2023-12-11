package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserController {

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        return "login"; // Thymeleaf template name (login.html)
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        return "register"; // Thymeleaf template name (register.html)
    }
    
}