package com.nhnacademy.edu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cs")
public class UserPageController {

    @GetMapping
    public String userInfoController(@ModelAttribute("user") String user) {
        if (user.equals("admin")) {
            return "admin/loginSuccess_admin";

        } else {
            return "customer/loginSuccess_customer";
        }

    }
}