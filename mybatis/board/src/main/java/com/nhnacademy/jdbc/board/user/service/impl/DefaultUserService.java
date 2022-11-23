package com.nhnacademy.jdbc.board.user.service.impl;


import com.nhnacademy.jdbc.board.user.domain.User;
import com.nhnacademy.jdbc.board.user.mapper.UserMapper;
import com.nhnacademy.jdbc.board.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
public class DefaultUserService implements UserService{

    private final UserMapper userMapper;


    public DefaultUserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    @Override
    public Optional<User> getUser(Long id) {
        return userMapper.selectUser(id);
    }

    @Override
    public Optional<User> getUserName(String userName) {
        return userMapper.selectUserByName(userName);
    }

    public boolean matches(String username, String password){
        Optional<User> user = userMapper.selectUserByName(username);


        log.info(user.get().getPassword());

        if(user.isPresent() && user.get().getPassword().equals(password)){
            return true;
        }
        return false;
    }

    @Override
    public List<User> getUsers() {
        return userMapper.selectUsers();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userMapper.deleteById(id);
    }



}
