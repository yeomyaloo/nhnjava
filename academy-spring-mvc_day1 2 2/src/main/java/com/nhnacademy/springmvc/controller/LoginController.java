package com.nhnacademy.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.nhnacademy.springmvc.repository.UserRepository;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;

import javax.servlet.http.*;
@Controller
public class LoginController {
    private final UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping
    public String login(@CookieValue(value = "SESSION", required = false) String session,
                        Model model) {
        if (StringUtils.hasText(session)) {
            model.addAttribute("id", session);
            return "home";
        } else {
            return "index";
        }
    }

    @PostMapping
    public String doLogin(@RequestParam("userId") String id,
                          @RequestParam("userPwd") String pwd,
                          HttpServletRequest request,
                          HttpServletResponse response,
                          ModelMap modelMap) {
        if (userRepository.matches(id, pwd)) {
            HttpSession session = request.getSession(true);

            Cookie cookie = new Cookie("SESSION", session.getId());
            response.addCookie(cookie);

            modelMap.put("id", session.getId());
            return "home";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/home")
    public String homeViewController(){
        return "home";
    }
}

