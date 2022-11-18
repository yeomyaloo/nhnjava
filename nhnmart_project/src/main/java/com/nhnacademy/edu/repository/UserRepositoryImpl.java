package com.nhnacademy.edu.repository;

import com.nhnacademy.edu.domain.User;
import com.nhnacademy.edu.exception.AlreadyExistUserException;

import java.util.*;

public class UserRepositoryImpl implements UserRepository{

    private final Map<String ,User> userMap = new HashMap();
    private User user;


    @Override
    public boolean exists(String id) {
        return userMap.containsKey(id);
    }

    @Override
    public boolean matches(String id, String pwd) {
        return Optional.ofNullable(getUser(id))
                .map(user -> user.getPassword().equals(pwd))
                .orElse(false);
    }

    @Override
    public User getUser(String id) {
        return exists(id) ? userMap.get(id) : null;
    }

    @Override
    public User addUser(String id, String pwd) {
        return addUser(id, pwd, "admin");
    }

    @Override
    public User addUser(String id, String pwd, String name) {
        if(exists(id)){
            throw new AlreadyExistUserException();
        }
        user =
    }

    @Override
    public User modify(User user) {
        return null;
    }
}
