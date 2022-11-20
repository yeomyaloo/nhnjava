package com.nhnacademy.edu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
@RequestMapping("/logout")
public class LogoutController {

    @GetMapping
    public String logoutController(HttpServletRequest request,HttpServletResponse response){

        HttpSession session = request.getSession(false);
        if(Objects.isNull(session)){
            return "redirect:/";
        }

        Cookie cookie = new Cookie("SESSION", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        Cookie cookieAdmin = new Cookie("SESSION_ADMIN", null);
        cookie.setMaxAge(0);
        response.addCookie(cookieAdmin);

        session.invalidate();
        return "redirect:/";
    }
}
