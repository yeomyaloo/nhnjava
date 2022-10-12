package com.nhnacademy.edu.springframework.greeting.service;

import com.nhnacademy.edu.springframework.greeting.Greeter;

public class EnglishGreeter implements Greeter {

    public EnglishGreeter() {
        System.out.println("english Greeter 생성!");
    }

    public void init(){
        System.out.println("EnglishGreeter initializing");
    }
    public void destroy(){
        System.out.println("EnglishGreeter clean - Up");
    }

    @Override
    public boolean sayHello() {
        System.out.println("say hello~");
        return true;
    }
}
