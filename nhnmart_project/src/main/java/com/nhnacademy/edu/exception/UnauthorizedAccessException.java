package com.nhnacademy.edu.exception;

public class UnauthorizedAccessException extends RuntimeException {

    public UnauthorizedAccessException() {
        super("unauthorized access error!!");
    }
}
