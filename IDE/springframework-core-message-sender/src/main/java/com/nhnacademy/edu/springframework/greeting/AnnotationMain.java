package com.nhnacademy.edu.springframework.greeting;

import com.nhnacademy.edu.springframework.greeting.config.MainConfig;
import com.nhnacademy.edu.springframework.greeting.config.ServiceConfig;
import com.nhnacademy.edu.springframework.greeting.service.KoreanGreeter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationMain {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            ServiceConfig.class, MainConfig.class);


        Greeter greeter = context.getBean("koreanGreeter", KoreanGreeter.class);
        greeter.sayHello();



        GreetingService service = context.getBean(GreetingService.class);
        service.doGreat();

        System.out.println("------------------------------------------------------");
        context.getBeanFactory().getBeanNamesIterator().forEachRemaining(s ->{
            System.out.println(s);
        });
        System.out.println("------------------------------------------------------");

    }


}
