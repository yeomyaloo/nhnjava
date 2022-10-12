package com.nhnacademy.edu.springframework.messagesender;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterInjectionMain {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        MessageSenderService service = context.getBean("messageSenderService", MessageSenderService.class);

        service.doSendMessage();
    }
}
