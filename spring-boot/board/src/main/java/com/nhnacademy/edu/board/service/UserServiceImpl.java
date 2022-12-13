package com.nhnacademy.edu.board.service;

import com.nhnacademy.edu.board.entity.Board;
import com.nhnacademy.edu.board.entity.User;
import com.nhnacademy.edu.board.exception.UserNotFoundException;
import com.nhnacademy.edu.board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;



@Service
@Validated
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{


    private final UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("user not found " + id));

    }

    @Override
    @Transactional
    public User createdUser(@Valid User user) {
        return userRepository.save(user);
    }


    @Override
    @Transactional
    public void deleteUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            userRepository.deleteById(id);
        }
        throw new UserNotFoundException("user not found");
    }

    @Override
    public boolean matchesUser(String userId, String password) {

        User user = userRepository.findByUserId(userId).orElseThrow(() -> new UserNotFoundException("user not found" + userId));

        if(user.getUserId().equals(userId)&&user.getPassword().equals(password)){
            return true;
        }
        return false;

    }
}
