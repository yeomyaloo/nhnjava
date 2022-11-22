package com.nhnacademy.edu.jdbc1.web;

import com.nhnacademy.edu.jdbc1.exception.UserNotFoundException;
import com.nhnacademy.edu.jdbc1.repository.UserRepository;
import com.nhnacademy.edu.jdbc1.service.login.UserLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CourseCreationController {
    private final UserLoginService userLoginService;
    private final UserRepository repository;
    public CourseCreationController(UserLoginService UserLoginService, UserRepository repository) {
        this.userLoginService = UserLoginService;
        this.repository = repository;
    }

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/login")
    public String loginFormController(){
        return "login";
    }

    @PostMapping("/login")
    public String loginPostController(@RequestParam("name") String name,
                                      @RequestParam("pwd") String pwd, Model model){

        if(userLoginService.matches(name,pwd)){
            return "redirect:/course";
        }
        throw new UserNotFoundException();

    }

    @GetMapping("/course")
    public String courseViewController(){


        return "courseList";
    }

    @ExceptionHandler(UserNotFoundException.class)
    public String userNotFound(Model model){

        model.addAttribute("userNotFound", UserNotFoundException.class);
        return "redirect:/login";

    }

}
