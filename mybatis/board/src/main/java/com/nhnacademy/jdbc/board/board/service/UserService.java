package com.nhnacademy.jdbc.board.board.service;

import com.nhnacademy.jdbc.board.user.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> getUser(Long id);
    Optional<User> getUserName(String userName);
    List<User> getUsers();
    boolean matches(String username, String password);
    void addUser(User user);
    void deleteUser(Long id);






}
