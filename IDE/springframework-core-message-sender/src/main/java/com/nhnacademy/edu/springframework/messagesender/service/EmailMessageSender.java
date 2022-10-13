package com.nhnacademy.edu.springframework.messagesender.service;

import com.nhnacademy.edu.springframework.messagesender.MessageSender;
import com.nhnacademy.edu.springframework.messagesender.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class EmailMessageSender implements MessageSender {

    @Autowired
    public EmailMessageSender() {
        System.out.println("EmailMessageSender 생성중...");
    }

    public void init(){
        System.out.println("init method called in SmsMessageSender");
    }

    public void destroy(){
        System.out.println("destroy method called in EmailMessageSender");
    }
    @Override
    public void sendMessage(User user, String message) {

        System.out.println("-----------SmsMessageSender-------------");
        System.out.printf("user: "+user.getEmail()+" message: "+ message);
        System.out.println();
    }

    @Override
    public boolean sendMessageBoolean(User user, String message) {
        return false;
    }
}
