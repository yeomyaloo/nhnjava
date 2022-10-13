package com.nhnacademy.edu.springframework.greeting.service;

import com.nhnacademy.edu.springframework.greeting.Greeter;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Component
public class KoreanGreeter implements Greeter {

    public KoreanGreeter() {
        System.out.println("koreanGreeter 생성!");
    }

    public  void close(){
        System.out.println("callback close()--------------");
    }
    @Override
    public boolean sayHello() {
        System.out.println("안녕 세상!");
        return true;
    }
}
