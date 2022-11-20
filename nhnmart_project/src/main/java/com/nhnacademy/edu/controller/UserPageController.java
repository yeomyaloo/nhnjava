package com.nhnacademy.edu.controller;


import com.nhnacademy.edu.domain.Post;
import com.nhnacademy.edu.domain.PostCategory;
import com.nhnacademy.edu.domain.PostWriteRequest;
import com.nhnacademy.edu.domain.User;
import com.nhnacademy.edu.exception.*;
import com.nhnacademy.edu.repository.PostRepository;
import com.nhnacademy.edu.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/cs")
public class UserPageController {

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    public UserPageController(UserRepository userRepository, PostRepository postRepository) {
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

    @ModelAttribute("inquiryList")
    public Map<Long ,Post> getPosts(){
        return postRepository.getPosts();
    }

    //해당 유저가 admin인 경우엔 admin 페이지로 넘겨준다.
    @GetMapping
    public String userInfoController(@ModelAttribute("authority") String authority) {
        if (Objects.isNull(authority)){
            throw new UserNotLoginException();
        }


        return "customer/loginSuccess_customer";
    }


    @GetMapping("/inquiry")
    public String userInquiryListController(){
        return "customer/inquiryList";
    }

    @GetMapping("inquiry/write")
    public String userInquiryWriteController(){
        return "customer/writeInquiry";
    }

    @PostMapping("inquiry/write")
    public String userInquiryWritePostController(@Valid @ModelAttribute PostWriteRequest request,
                                                 BindingResult result, Model model){
        if (result.hasErrors()) {
            throw new ValidationFailedException(result);
        }
        Post post = postRepository.registerPost(request.getTitle(), request.getPostCategory(), request.getContent());
        model.addAttribute("post",post);
        return "redirect:/cs/inquiry";

    }

    @GetMapping("/inquiry/{inquiryNo}")
    public String inquiryDetailViewController(@PathVariable(value = "inquiryNo", required = false) long inquiryNo,
                                              Model model){
        if(!postRepository.exist(inquiryNo)){
            throw new PostNotFoundException();
        }

        Post post = postRepository.getPost(inquiryNo);
        model.addAttribute("post", post);
        return "customer/inquiryDetailView";

    }

    @GetMapping("/inquiry/search")
    public String searchInquiryListController(@RequestParam(value = "postCategory", required = false) PostCategory postCategory,
                                              Model model){

        List<Post> searchList = postRepository.getPosts().values().stream().filter(i -> i.getPostCategory().equals(postCategory)).collect(Collectors.toList());
        if(Objects.isNull(searchList)){
            throw new PostNotExistCategory();
        }
        model.addAttribute("searchList", searchList);
        return "customer/search";
    }

    /** 예외발생시 처리 로직 */
    @ExceptionHandler(UnauthorizedAccessException.class)
    public String unAuthorizedAccess(UnauthorizedAccessException unauthorizedAccessException){
        return "redirect:/";
    }

    @ExceptionHandler(UserNotLoginException.class)
    public String notLogin(){
        return "redirect:/";
    }

    @ExceptionHandler(PostNotFoundException.class)
    public String postNotFound(){
        return "redirect:/cs/inquiry";
    }

    @ExceptionHandler(PostNotExistCategory.class)
    public String postNotExistCategory(Model model){
        model.addAttribute("postNotExistCategory", PostNotExistCategory.class);
        return "redirect:/inquiry/search";
    }
}