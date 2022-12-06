package com.nhnacademy.edu.jpa.exception;

public class ResidentDoesNotExistException extends RuntimeException {

    public ResidentDoesNotExistException() {
        super("user does not exist");
    }
}
