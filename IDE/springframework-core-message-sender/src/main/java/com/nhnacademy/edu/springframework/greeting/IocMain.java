package com.nhnacademy.edu.springframework.greeting;

import com.nhnacademy.edu.springframework.greeting.service.KoreanGreeter;

public class IocMain {

    public static void main(String[] args) {
        new GreetingService(new KoreanGreeter()).doGreat();
    }

}
