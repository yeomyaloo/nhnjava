package com.nhnacademy.edu.springframework.greeting;

import com.nhnacademy.edu.springframework.greeting.service.KoreanGreeter;

public class IocMain {



    public static void main(String[] args) {
        Greeter koreanGreeter = new KoreanGreeter();
        GreetingService greetingService = new GreetingService(koreanGreeter);


        new GreetingService(new KoreanGreeter()).doGreat();



        greetingService.doGreat();
        koreanGreeter.sayHello();
    }

}
