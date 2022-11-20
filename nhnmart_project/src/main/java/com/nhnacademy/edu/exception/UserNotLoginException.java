package com.nhnacademy.edu.exception;

public class UserNotLoginException extends RuntimeException {
    public UserNotLoginException() {
        super("login please!!");
    }
}
