package com.nhnacademy.edu.jdbc1.repository;

import com.nhnacademy.edu.jdbc1.domain.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserRepository {


    User findByUserName(String userName);

    void insert(User user) throws SQLException;

    List<User> findAll();

    int deleteById(Long id);


}
