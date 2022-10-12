package com.nhnacademy.edu.springframework.messagesender.service;

import com.nhnacademy.edu.springframework.messagesender.MessageSender;
import com.nhnacademy.edu.springframework.messagesender.User;

public class EmailMessageSender implements MessageSender {


    public void init(){
        System.out.println("init method called in SmsMessageSender");
    }

    public void destroy(){
        System.out.println("destroy method called in EmailMessageSender");
    }
    @Override
    public void sendMessage(User user, String message) {
        System.out.printf("user: "+user.getEmail()+" message: "+ message);
        System.out.println();
    }
}
