package com.nhnacademy.edu.hwiju.tdd.acoount;

public class LoginFailedException extends RuntimeException {
    public LoginFailedException(String username) {
        System.out.println(username);
    }


}
