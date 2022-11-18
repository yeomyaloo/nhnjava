package com.nhnacademy.edu.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class LoginController {

    @GetMapping("/login")
    public String loginFormController(){
        return "index";
    }
}
