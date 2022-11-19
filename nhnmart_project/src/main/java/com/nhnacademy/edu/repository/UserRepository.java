package com.nhnacademy.edu.repository;

import com.nhnacademy.edu.domain.User;

public interface UserRepository {


    public boolean exists(String id);

    public boolean matches(String id, String pwd);

    public User getUser(String id);

    public User addUser(String id, String pwd);

    public User addUser(String id, String pwd, String name);

    public User modify(User user);
}
