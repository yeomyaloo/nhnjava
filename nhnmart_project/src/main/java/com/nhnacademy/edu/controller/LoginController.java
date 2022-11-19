package com.nhnacademy.edu.controller;

import com.nhnacademy.edu.domain.User;
import com.nhnacademy.edu.domain.UserRole;
import com.nhnacademy.edu.exception.UserNotMatcheException;
import com.nhnacademy.edu.repository.UserRepository;
import com.nhnacademy.edu.repository.UserRepositoryImpl;
import com.oracle.wls.shaded.org.apache.xpath.operations.Mod;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {

    private UserRepository userRepository;
    public LoginController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping
    public String isLogin(@CookieValue(value = "SESSION", required = false) String session){
        if(StringUtils.hasText(session)){
            return "redirect:/cs";
        }
        return "loginForm";
    }

    @PostMapping
    public String doLogin(@RequestParam("id") String id,
                        @RequestParam("pwd") String pwd,
                        HttpServletRequest request,
                        HttpServletResponse response, Model model){
        if(userRepository.matches(id, pwd)){
            HttpSession session = request.getSession(true);
            Cookie cookie = new Cookie("SESSION", session.getId());
            response.addCookie(cookie);

            if(id.equals("admin")){
                model.addAttribute("user", "admin");
            } else {
                model.addAttribute("user", "customer");
            }

            return "redirect:/cs";
        }
        throw new UserNotMatcheException();
    }

    @ExceptionHandler(UserNotMatcheException.class)
    public String userNotMatches(UserNotMatcheException userNotMatchException, Model model){

        model.addAttribute("userNotMatchException", userNotMatchException);
        return "loginForm";
    }


}
