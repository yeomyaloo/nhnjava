package com.nhnacademy.edu.hwiju.tdd.acoount;

public class AccountService {
    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public void join(Account account){
        repository.insert(account);
    }


    public Account login(String username, String password) {
        Account result = repository.findByUsername(username);
        if (result == null) {
            return null;
        }
        return result;
    }
}
