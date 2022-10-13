package com.nhnacademy.edu.springframework.messagesender;

import com.nhnacademy.edu.springframework.messagesender.config.MainConfig;
import com.nhnacademy.edu.springframework.greeting.config.ServiceConfig;
import com.nhnacademy.edu.springframework.messagesender.service.DoorayMessageSender;
import com.nhnacademy.edu.springframework.messagesender.service.SmsMessageSender;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationMain {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        DoorayMessageSender doorayMessageSender = context.getBean("doorayMessageSender", DoorayMessageSender.class);

        User user = new User("염휘주", "00");
        doorayMessageSender.sendMessageBoolean(user,"hi");



    }

}
