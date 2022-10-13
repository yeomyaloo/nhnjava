package com.nhnacademy.edu.springframework.greeting.config;

import com.nhnacademy.edu.springframework.greeting.Greeter;
import com.nhnacademy.edu.springframework.greeting.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = {"com.nhnacademy.edu.springframework.greeting"})
public class ServiceConfig {

/*
    @Autowired
    private Greeter koreanGreeter;

    @Autowired
    private MainConfig mainConfig;

    @Bean
    public GreetingService greeterService(){
        //return new ServiceGreeter(koreanGreeter);
        return new GreetingService(koreanGreeter);

        //return new GreetingService(mainConfig.koreanGreeter());
    }*/
}
