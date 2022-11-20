package com.nhnacademy.edu.config;

import com.nhnacademy.edu.Base;

import com.nhnacademy.edu.domain.PostCategory;
import com.nhnacademy.edu.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackageClasses = Base.class,
    excludeFilters = { @ComponentScan.Filter(Controller.class)})
@Slf4j
public class RootConfig {

    @Bean
    public UserRepository userRepository(){
        UserRepository userRepository = new UserRepositoryImpl();
        userRepository.addUser("admin", "1234");
        userRepository.addUser("customer", "1234","customer");
        return userRepository;
    }

    @Bean
    public PostRepository postRepository(){
        PostRepository postRepository  = new PostRepositoryImpl();
        postRepository.registerPost("test1", PostCategory.불만_접수, "불만을 접수합니다.");
        return postRepository;
    }




}
