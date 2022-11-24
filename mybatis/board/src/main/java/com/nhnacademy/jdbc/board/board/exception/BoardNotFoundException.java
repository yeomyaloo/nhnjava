package com.nhnacademy.jdbc.board.board.exception;

public class BoardNotFoundException extends RuntimeException {
    public BoardNotFoundException() {
        super("Not Found Board!!");
    }
}
