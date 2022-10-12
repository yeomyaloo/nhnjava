package com.nhnacademy.edu.springframework.greeting2;

public class GreetingService {

    private final Greeter greeter;

    public GreetingService(Greeter greeter) {
        this.greeter = greeter;
    }

    //인터페이스의 메소드를 호출하지만 실제 구현 객체의 메소드가 실행
    public boolean great(){
        return greeter.sayHello();
    }
}
