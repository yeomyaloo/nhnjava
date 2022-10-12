package com.nhnacademy.edu.springframework.greeting;

import com.nhnacademy.edu.springframework.greeting.service.KoreanGreeter;

public class ComplexGreetingService {

    public boolean greet() {
        return new KoreanGreeter().sayHello();

    }
}
