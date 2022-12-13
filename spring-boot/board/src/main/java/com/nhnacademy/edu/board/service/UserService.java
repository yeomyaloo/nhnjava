package com.nhnacademy.edu.board.service;

import com.nhnacademy.edu.board.entity.Board;
import com.nhnacademy.edu.board.entity.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();
    User getUser(Long id);
    User createdUser(User user);
    //User modifyUserById(Long id);
    void deleteUserById(Long id);

    boolean matchesUser(String userId, String password);


}
