package com.nhnacademy.jdbc.board.board.exception;

public class BoardNotExistException extends RuntimeException {

    public BoardNotExistException() {
        super("Board Not Exist Error!!");
    }
}
