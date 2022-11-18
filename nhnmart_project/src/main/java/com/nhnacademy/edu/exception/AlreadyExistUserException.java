package com.nhnacademy.edu.exception;

public class AlreadyExistUserException extends RuntimeException {

    public AlreadyExistUserException() {
        super("already exist user!!");
    }
}
