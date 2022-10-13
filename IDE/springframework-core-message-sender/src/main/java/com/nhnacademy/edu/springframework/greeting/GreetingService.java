package com.nhnacademy.edu.springframework.greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * GreetingService는 외부에서 생성된 객체를 사용, 객체 생성의 책임이 없다.
 * */

@Component
public class GreetingService {

    private final Greeter greeter;

/*    @Value("${from}")
    private String from;*/


    @Autowired
    public GreetingService(Greeter koreanGreeter) {
        System.out.println("------------------- Constructor Injection ----------------------");
        this.greeter = koreanGreeter;
    }

    public void doGreat(){
        greeter.sayHello();
    }
/*    public boolean greet(){
        System.out.println("From : "+from);
        return greeter.sayHello();
    }*/

}
