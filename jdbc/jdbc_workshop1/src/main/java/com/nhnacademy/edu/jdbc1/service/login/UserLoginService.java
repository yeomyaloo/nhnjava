package com.nhnacademy.edu.jdbc1.service.login;

import com.nhnacademy.edu.jdbc1.domain.User;

import java.util.List;

public interface UserLoginService {

    User getUser(String id);
    List<User> getAllUsers();

    void addUser(User user);

    int deleteUser(Long id);

    boolean matches(String name, String password);


}
