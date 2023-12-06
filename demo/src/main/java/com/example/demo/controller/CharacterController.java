package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CharacterController {

    @GetMapping("/create-character")
    public String showCharacterCreationPage(Model model) {
        // You can add any necessary model attributes if needed
        return "create-character"; // Thymeleaf template name (create-character.html)
    }
}