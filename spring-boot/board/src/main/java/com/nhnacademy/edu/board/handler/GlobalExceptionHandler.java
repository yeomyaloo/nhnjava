package com.nhnacademy.edu.board.handler;


import com.nhnacademy.edu.board.exception.UserNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {UserNotFoundException.class})
    public String userNotFoundExceptionHandler(){
        return "";
    }

}
