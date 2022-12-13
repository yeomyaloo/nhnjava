package com.nhnacademy.edu.board.controller;


import com.nhnacademy.edu.board.service.UserNotMatchesException;
import com.nhnacademy.edu.board.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String doLogin(@CookieValue(value = "SESSION", required = false) String session,
                          Model model) {

        if (StringUtils.hasText(session)) {
            model.addAttribute("id", session);
            return "home";

        }
        return "login";
    }


    @PostMapping
    public String loginPostController(@RequestParam("userId") String userId,
                                      @RequestParam("password")String password,
                                      HttpServletRequest request,
                                      HttpServletResponse response,
                                      Model model){

        if(userService.matchesUser(userId, password)){

            HttpSession session = request.getSession(true);
            Cookie cookie = new Cookie("SESSION", session.getId());

            response.addCookie(cookie);

            model.addAttribute("id", session.getId());
            return "home";

        }
        throw new UserNotMatchesException();
    }

    @ExceptionHandler(value = UserNotMatchesException.class)
    public String userNotMatchesExceptionHandler(Model model){
        model.addAttribute("userNotMatchesException", UserNotMatchesException.class);

        return "redirect:/login";

    }

}
