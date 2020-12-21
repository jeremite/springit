package com.travis.springit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AutoController {
    @GetMapping("/login")
    public String login(){
        return "auth/login";
}
}
