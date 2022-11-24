package com.nhnacademy.jdbc.board.board.service.impl;

import com.nhnacademy.jdbc.board.board.domain.Board;
import com.nhnacademy.jdbc.board.board.mapper.BoardMapper;
import com.nhnacademy.jdbc.board.user.domain.User;
import com.nhnacademy.jdbc.board.user.mapper.UserMapper;
import com.nhnacademy.jdbc.board.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class DefaultBoardServiceTest {

    private final UserMapper userMapper;
    private final UserService userService;

    public DefaultBoardServiceTest(UserMapper userMapper, UserService userService) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    @ParameterizedTest
    void insertTest(){
        User user = new User("asdsda","asdasd");
        userService.addUser(user);
        assertTrue(userService.matches("asdsda", "asdasd"));



    }

}