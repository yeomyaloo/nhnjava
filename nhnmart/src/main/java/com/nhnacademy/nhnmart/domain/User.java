package com.nhnacademy.nhnmart.domain;

public class User {

    private final long id;
    private final String password;
    private String name;

    public User(long id, String password) {
        this.id = id;
        this.password = password;
    }



}
