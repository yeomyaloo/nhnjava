package com.nhnacademy.jdbc.board.user.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("user not found error !!");
    }
}
