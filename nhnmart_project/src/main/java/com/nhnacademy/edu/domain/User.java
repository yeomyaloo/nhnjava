package com.nhnacademy.edu.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class User{
    private final String id;
    private final String pwd;
    private String name;
    private UserRole userRole;

    public User(String id, String password, String name) {
        this.id = id;
        this.pwd = password;
        this.name = name;
    }

    public static User create(String id, String pwd, String name, UserRole userRole) {
        return new User(id, pwd, name, userRole);
    }
}
