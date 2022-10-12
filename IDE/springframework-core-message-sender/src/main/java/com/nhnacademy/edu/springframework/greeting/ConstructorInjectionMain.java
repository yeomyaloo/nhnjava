package com.nhnacademy.edu.springframework.greeting;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstructorInjectionMain {

    public static void main(String[] args) {
        String location = "classpath:/beans.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(location);

        GreetingService service = context.getBean("greetingService", GreetingService.class);

        service.doGreat();

    }

}
