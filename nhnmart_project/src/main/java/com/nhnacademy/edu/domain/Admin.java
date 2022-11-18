package com.nhnacademy.edu.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Admin implements User{
    private final String id;
    private final String password;
    private String name;


    @Override
    public User create(String id, String pwd) {
        return null;
    }
}
