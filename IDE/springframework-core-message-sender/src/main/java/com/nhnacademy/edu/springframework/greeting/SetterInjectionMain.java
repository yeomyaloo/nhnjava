package com.nhnacademy.edu.springframework.greeting;

import com.nhnacademy.edu.springframework.messagesender.MessageSenderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterInjectionMain {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        GreetingService service = context.getBean("greetingService", GreetingService.class);

        service.doGreat();


/*        //리스트로 받은 것
        ClassPathXmlApplicationContext context2 = new ClassPathXmlApplicationContext("beans.xml");
        GreetingsService service2 = context2.getBean("greetingsService", GreetingsService.class);

        service2.greet();*/
    }

}
