package com.nhnacademy.edu.jdbc1.service.login;

import com.nhnacademy.edu.jdbc1.domain.User;
import com.nhnacademy.edu.jdbc1.exception.UserNotFoundException;
import com.nhnacademy.edu.jdbc1.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@Service
public class DefaultUserLoginService implements UserLoginService {

    private final UserRepository userRepository;

    public DefaultUserLoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUser(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        try {
            userRepository.insert(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public int deleteUser(Long id) {

        try {
            return userRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean matches(String name, String password) {
        User user = userRepository.findByUserName(name);
        if (Objects.nonNull(user) && user.getUserName().equals(name) && user.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}


