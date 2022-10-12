package com.nhnacademy.edu.springframework.greeting;

/**
 * ComplexGreetingService를 작성해
 * KoreanGreeter 객체를 생성하는 제어를 스스로 구현한 케이스
 * */
public class NonIocMain {

    public static void main(String[] args) {
        new ComplexGreetingService().greet();

    }

}
