package com.nhnacademy.edu.config;

import com.nhnacademy.edu.Base;

import com.nhnacademy.edu.repository.UserRepository;
import com.nhnacademy.edu.repository.UserRepositoryImpl;
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

//    @Bean
//    public StudentRepository studentRepository() {
//        StudentRepository studentRepository = new StudentRepositoryImpl();
//        studentRepository.register("김학생", "kim.student@nhnacademy.com", 100, "훌륭");
//
//        return studentRepository;
//    }

    @Bean
    public UserRepository userRepository(){
        UserRepository userRepository = new UserRepositoryImpl();
        userRepository.addUser("admin", "1234");
        userRepository.addUser("customer", "1234","customer");

        System.out.println(userRepository.getUser("admin"));
        return userRepository;
    }

}
