package com.location.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.location.project.entity.User;
import com.location.project.service.UserService;
import com.location.project.serviceimp.UserServiceImpl;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private UserServiceImpl userServiceimpl;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password, Model model, User user) {
        if (userServiceimpl.isUsernameTaken(username)) {
            model.addAttribute("error", "Username is already taken. Please choose a different one.");
            return "register"; // Redirect back to registration page with an error message
        }

        userService.saveUser(user);
        model.addAttribute("success", "Registration successful! Plesase click on LOGIN..");
        return "register";
    }
}
