package com.nhnacademy.edu.exception;

public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException() {
        super("Not Found Post Error!!");
    }
}
