package com.nhnacademy.edu.springframework.greeting2;

public class EnglishGreeter implements Greeter{

    @Override
    public boolean sayHello() {
        System.out.println("Hello world!");
        return true;
    }
}
