package com.nhnacademy.edu.controller;


import com.nhnacademy.edu.domain.Post;
import com.nhnacademy.edu.domain.User;
import com.nhnacademy.edu.exception.PostNotFoundException;
import com.nhnacademy.edu.exception.UnauthorizedAccessException;
import com.nhnacademy.edu.exception.UserNotLoginException;
import com.nhnacademy.edu.repository.PostRepository;
import com.nhnacademy.edu.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/cs/admin")
public class AdminPageController {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public AdminPageController(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @ModelAttribute("user")
    public User getUser(@ModelAttribute("authority") String authority) {
        String userId = "";
        if (authority.equals("admin")) {
            userId = "admin";
        } else {
            userId = "customer";
        }
        User user = userRepository.getUser(userId);
        return user;
    }

    @ModelAttribute("adminAnswerList")
    public List<Post> getAdminAnswerList(){
        return postRepository.getPosts().values().stream().filter(i -> i.isCheck() == false).collect(Collectors.toList());
    }


    @GetMapping
    public String adminInfoController(@CookieValue(value = "SESSION_ADMIN", required = false) String adminSession) {
        if(StringUtils.hasText(adminSession)){
            return "admin/loginSuccess_admin";
        }
        throw new UnauthorizedAccessException();
    }


    @GetMapping("/inquiry")
    public String inquiryFormController(){
        return "/admin/inquiryList";
    }

    @GetMapping("/inquiry/{inquiryNo}")
    public String inquiryDetailView(@PathVariable(value = "inquiryNo", required = false)long inquiryNo,
                                    Model model){

        if(!postRepository.exist(inquiryNo)){
            throw new PostNotFoundException();
        }

        Post post = postRepository.getPost(inquiryNo);
        model.addAttribute("post", post);
        return "admin/inquiryDetailView";
    }


    @GetMapping("/inquiry/answer")
    public String adminAnswerFormController(){
        return "admin/inquiryAnswerForm";
    }






    /**
     * 에러관련 핸들러 처리 로직
     * */
    @ExceptionHandler(UnauthorizedAccessException.class)
    public String unAuthorizedAccess(UnauthorizedAccessException unauthorizedAccessException){

        return "redirect:/";
    }

    @ExceptionHandler(UserNotLoginException.class)
    public String notLogin(){
        return "redirect:/";
    }
}