package com.nhnacademy.edu.board.domain;


import javax.validation.constraints.NotNull;

public class CreateUserRequest {

    @NotNull
    private String userName;

    @NotNull
    private String password;
}
