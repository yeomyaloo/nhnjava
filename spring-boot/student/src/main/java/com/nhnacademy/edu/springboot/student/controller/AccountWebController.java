package com.nhnacademy.edu.springboot.student.controller;


import com.nhnacademy.edu.springboot.student.model.Account;
import com.nhnacademy.edu.springboot.student.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class AccountWebController {



    private final AccountService accountService;

    @GetMapping("/account/{id}")
    public String getAccount(@PathVariable("id") Long id, Model model){



        return "account";
    }
}
