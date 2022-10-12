package com.nhnacademy.edu.springframework.greeting2;

public class Main {

    public static void main(String[] args) {
        new GreetingService(new EnglishGreeter()).great();
        new GreetingService(new KoreanGreeter()).great();

    }
}
