package com.nhnacademy.edu.config;

import com.nhnacademy.edu.Base;

import com.nhnacademy.edu.repository.UserRepository;
import com.nhnacademy.edu.repository.CustomerRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackageClasses = Base.class,
    excludeFilters = { @ComponentScan.Filter(Controller.class)})
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
        UserRepository userRepository = new CustomerRepositoryImpl();
        userRepository.addUser("admin", "1234");
//        userRepository.addUser("user", "user1234", "김철수")
        return userRepository;
    }

}
