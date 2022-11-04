package com.nhnacademy.exception;

public class InvalidCalculateUnderZero extends RuntimeException {

    public InvalidCalculateUnderZero() {
        super("invalid calculate under zero!");
    }
}
