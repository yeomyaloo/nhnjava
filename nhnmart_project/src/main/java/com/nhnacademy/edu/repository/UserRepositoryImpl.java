package com.nhnacademy.edu.repository;

import com.nhnacademy.edu.domain.User;
import com.nhnacademy.edu.domain.UserRole;
import com.nhnacademy.edu.exception.AlreadyExistUserException;
import com.nhnacademy.edu.exception.UserNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.*;


public class UserRepositoryImpl implements UserRepository{

    private final Map<String, User> userMap = new HashMap();


    @Override
    public boolean exists(String id) {
        return userMap.containsKey(id);
    }

    @Override
    public boolean matches(String id, String pwd) {
        return Optional.ofNullable(getUser(id))
                .map(user -> user.getPwd().equals(pwd))
                .orElse(false);
    }

    @Override
    public User getUser(String id) {
        if(!exists(id)){
            throw new UserNotFoundException();
        }
        return userMap.get(id);
    }

    @Override
    public User addUser(String id, String pwd) {
        User admin = User.create(id, pwd, "admin", UserRole.ADMIN);
        userMap.put("admin", admin);
        return admin;

    }

    @Override
    public User addUser(String id, String pwd, String name) {
        if(exists(id)){
            throw new AlreadyExistUserException();
        }
        User user = User.create(id, pwd, name, UserRole.CUSTOMER);
        userMap.put(user.getId(), user);
        return user;
    }

    @Override
    public User modify(User user) {
        User modifyUser = getUser(user.getId());
        if(Objects.isNull(modifyUser)){
            throw new UserNotFoundException();
        }

        modifyUser = new User(modifyUser.getId(), user.getPwd(), user.getName(), user.getUserRole());
        return modifyUser;
    }
}
