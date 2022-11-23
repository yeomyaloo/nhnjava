package com.nhnacademy.jdbc.board.index.web;


import com.nhnacademy.jdbc.board.user.exception.UserNotMatchesException;
import com.nhnacademy.jdbc.board.user.mapper.UserMapper;
import com.nhnacademy.jdbc.board.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    private final UserMapper userMapper;
    private final UserService userService;

    public LoginController(UserMapper userMapper, UserService userService) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(@CookieValue(value = "SESSION", required = false) String session,
            Model model){

        if(StringUtils.hasText(session)){
            model.addAttribute("id", session);
            return "redirect:/home";
        } else{
            return "login";
        }
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam("id") String id,
                          @RequestParam("pwd") String pwd,
                          HttpServletRequest request,
                          HttpServletResponse response,
                          Model model){

        if (userService.matches(id, pwd)){
            HttpSession session = request.getSession(true);

            Cookie cookie = new Cookie("SESSION", session.getId());
            response.addCookie(cookie);

            model.addAttribute("id", session.getId());
            return "home";
        }
        throw new UserNotMatchesException();
    }



    @ExceptionHandler(UserNotMatchesException.class)
    public String userNotMatches(Model model){
        model.addAttribute("userNotMatchesException", UserNotMatchesException.class);
        return "redirect:/login";
    }
}
