package com.travis.springit.controller;

//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody
@RestController
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "Hello,Spirng boot2!";
    }
}
