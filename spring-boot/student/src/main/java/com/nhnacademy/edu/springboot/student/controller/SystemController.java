package com.nhnacademy.edu.springboot.student.controller;


import com.nhnacademy.edu.springboot.student.config.SystemAuthorProperties;
import com.nhnacademy.edu.springboot.student.config.SystemVersionProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemController {


//    @Value("${system.author.name}")
//    private String author;

    private SystemAuthorProperties systemAuthorProperties;

    private SystemVersionProperties systemVersionProperties;

    @GetMapping("/system/author")
    public String getAuthor(){

        return systemAuthorProperties.getName();

    }

    @GetMapping("/system/version")
    public String getVersion(){
        return systemVersionProperties.getVersion();
    }





}
