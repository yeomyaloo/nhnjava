package com.nhnacademy.jdbc.board.index.web;


import com.nhnacademy.jdbc.board.user.exception.UserNotMatchesException;
import com.nhnacademy.jdbc.board.user.mapper.UserMapper;
import com.nhnacademy.jdbc.board.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
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
            @CookieValue(value = "SESSION_ADMIN", required = false)String adminSession,
            HttpServletRequest request,
            Model model){
        if(StringUtils.hasText(session)){
            model.addAttribute("id", session);
            HttpSession httpSession = request.getSession(true);
            httpSession.setAttribute("userName", "user");
            return "redirect:/board";


        } else if (StringUtils.hasText(adminSession)) {
            model.addAttribute("id", session);
            HttpSession httpSession = request.getSession(true);
            httpSession.setAttribute("userName", "admin");
            return "redirect:/board";


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

            Cookie cookie;
            if(id.equals("admin")){
                cookie = new Cookie("SESSION_ADMIN", session.getId());
            }else {
                cookie = new Cookie("SESSION", session.getId());

            }
            response.addCookie(cookie);
            session.setAttribute("userName",id);
            model.addAttribute("id", session.getId());
            return "redirect:/board";
        }
        throw new UserNotMatchesException();
    }



    @ExceptionHandler(UserNotMatchesException.class)
    public String userNotMatches(Model model){
        model.addAttribute("userNotMatchesException", UserNotMatchesException.class);
        return "redirect:/login";
    }
}
