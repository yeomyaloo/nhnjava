package com.nhnacademy.gw1.parking.exception;

public class AlreadyExistsUserIdException extends RuntimeException {
    public AlreadyExistsUserIdException() {
        super("already user id");
    }
}
