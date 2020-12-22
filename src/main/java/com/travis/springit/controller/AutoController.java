package com.travis.springit.controller;

import com.travis.springit.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AutoController {

    private UserService userService;

    public AutoController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(){
        return "auth/login";
}
    @GetMapping("/profile")
    public String profile() {
        return "auth/profile";
    }

    @GetMapping("/register")
    public String register() {
        return "auth/register";
    }
}
