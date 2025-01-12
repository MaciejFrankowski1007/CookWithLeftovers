package com.cookwithleftovers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(String username, String password, Model model) {
        // Mock authentication logic
        if ("admin".equals(username) && "password".equals(password)) {
            return "redirect:/recipes/search";
        } else {
            model.addAttribute("error", "Invalid username or password.");
            return "login";
        }
    }

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }

    @PostMapping("/register")
    public String processRegistration(String username, String password, Model model) {
        model.addAttribute("message", "Registration successful. Please log in.");
        return "login";
    }
}
