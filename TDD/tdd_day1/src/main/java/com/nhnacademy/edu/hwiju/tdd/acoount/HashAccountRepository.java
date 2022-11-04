package com.nhnacademy.edu.hwiju.tdd.acoount;

import java.util.HashMap;
import java.util.Objects;

public class HashAccountRepository implements AccountRepository {

    private final HashMap<Long, Account> source = new HashMap<>();

    @Override
    public void insert(Account account) {
        source.put(account.getId(), account);
    }

    @Override
    public Account findByUsername(String username) {
        return source.get(username);
    }


}
