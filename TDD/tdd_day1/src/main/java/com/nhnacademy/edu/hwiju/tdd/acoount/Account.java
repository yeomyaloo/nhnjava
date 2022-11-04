package com.nhnacademy.edu.hwiju.tdd.acoount;

public class Account {

    private Long id;
    private String username;
    private String password;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    private static long nextUuid(){
        return System.currentTimeMillis();
    }

    public Long getId(){
        return id;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

}
