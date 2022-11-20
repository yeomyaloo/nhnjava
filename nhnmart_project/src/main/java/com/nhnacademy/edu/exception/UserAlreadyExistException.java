package com.nhnacademy.edu.exception;

public class UserAlreadyExistException extends RuntimeException {

    public UserAlreadyExistException() {
        super("already exist user!!");
    }
}
