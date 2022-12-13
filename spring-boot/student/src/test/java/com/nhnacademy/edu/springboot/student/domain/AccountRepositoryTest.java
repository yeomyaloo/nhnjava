package com.nhnacademy.edu.springboot.student.domain;

import com.nhnacademy.edu.springboot.student.model.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AccountRepositoryTest {


    @Autowired
    AccountRepository accountRepository;


    @Test
    void testAccountRepository() {

        //given
        Account account = new Account(1L, "ddd", 10000);
        accountRepository.save(account);


        //when
        Optional<Account> byId = accountRepository.findById(1L);


        //then
        assertThat(byId).isPresent();
        assertThat(byId.get().getAccountId()).isEqualTo(1L);


    }
}