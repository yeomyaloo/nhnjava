package com.nhnacademy.edu.springframework.project.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan(basePackages = "com.nhnacademy.edu.springframework.project")
@Configuration
@EnableAspectJAutoProxy
public class ServiceConfig {

}
