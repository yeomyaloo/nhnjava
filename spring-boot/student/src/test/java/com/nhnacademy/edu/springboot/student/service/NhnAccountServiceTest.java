package com.nhnacademy.edu.springboot.student.service;

import com.nhnacademy.edu.springboot.student.model.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NhnAccountServiceTest {


    @Autowired
    AccountService accountService;


    @Test
    void getAccountTest() {
        List<Account> accounts = accountService.getAccounts();

        assertThat(accounts).hasSize(2);

    }
}