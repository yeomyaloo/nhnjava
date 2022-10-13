package com.nhnacademy.edu.springframework.greeting.config;


import com.nhnacademy.edu.springframework.greeting.Greeter;
import com.nhnacademy.edu.springframework.greeting.service.KoreanGreeter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.nhnacademy.edu.springframework.greeting")
public class MainConfig {

//
//    @Bean
//    public Greeter koreanGreeter(){
//        return new KoreanGreeter();
//    }



}
