package com.nhnacademy.edu.springframework.greeting.service;

import com.nhnacademy.edu.springframework.greeting.Greeter;
import org.springframework.beans.factory.annotation.Autowired;

public class KoreanGreeter implements Greeter {

    public KoreanGreeter() {
        System.out.println("koreanGreeter 생성!");
    }

    @Override
    public boolean sayHello() {
        System.out.println("안녕 세상!");
        return true;
    }
}
