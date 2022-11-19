package com.nhnacademy.edu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
@RequestMapping("/logout")
public class LogoutController {

    @GetMapping
    public String logoutController(HttpServletRequest request){

        HttpSession session = request.getSession(false);

        if(Objects.isNull(session)){
            return "redirect:/";
        }
        session.invalidate();
        return "redirect:/";
    }
}
