package com.nhnacademy.edu.hwiju.tdd.acoount;

public interface AccountRepository {
    void insert(Account account);


    Account findByUsername(String username);
}
