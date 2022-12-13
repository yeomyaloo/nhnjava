package com.nhnacademy.edu.springboot.student.service;


import com.nhnacademy.edu.springboot.student.domain.AccountRepository;
import com.nhnacademy.edu.springboot.student.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NhnAccountService implements AccountService{


    private final AccountRepository accountRepository;

    @Override
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }



    @Override
    public Account getAccount(Long id) {
        return accountRepository.findById(id).orElseThrow(()->new RuntimeException("not found account" + id));
    }

    @Override
    @Transactional(readOnly = true)
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    @Transactional(readOnly = true)
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}
