package com.nhnacademy.gw1.parking.exception;

public class AlreadyExistsCarNumberException extends RuntimeException {
    public AlreadyExistsCarNumberException() {
        super("car number that already exists");
    }
}
