package com.nhnacademy.edu.exception;

public class UserNotMatcheException extends RuntimeException {
    public UserNotMatcheException() {
        super("유효한 아이디와 비밀번호가 아닙니다. 다시 확인해주세요.");
    }
}
