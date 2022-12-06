package com.nhnacademy.edu.jpa.exception;

public class ResidentNotFoundException extends RuntimeException {
    public ResidentNotFoundException() {
        super("not found resident");
    }
}
