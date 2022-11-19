package com.nhnacademy.edu.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("user not found error!!");
    }
}
