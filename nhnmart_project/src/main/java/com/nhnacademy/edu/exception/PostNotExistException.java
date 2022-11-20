package com.nhnacademy.edu.exception;

public class PostNotExistException extends RuntimeException {

    public PostNotExistException() {
        super("Not exist Post Error!!");
    }
}
