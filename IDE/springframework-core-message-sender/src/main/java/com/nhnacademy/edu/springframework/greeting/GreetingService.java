package com.nhnacademy.edu.springframework.greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * GreetingService는 외부에서 생성된 객체를 사용, 객체 생성의 책임이 없다.
 * */
public class GreetingService {

    private final Greeter greeter;




    public GreetingService(@Autowired @Qualifier("englishGreeter") Greeter greeter) {
        System.out.println("------------------- Constructor Injection ----------------------");
        this.greeter = greeter;
    }

    public void doGreat(){
        greeter.sayHello();
    }
}
