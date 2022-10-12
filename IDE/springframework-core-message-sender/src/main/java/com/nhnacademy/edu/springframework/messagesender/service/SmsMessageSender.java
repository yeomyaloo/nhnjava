package com.nhnacademy.edu.springframework.messagesender.service;

import com.nhnacademy.edu.springframework.messagesender.MessageSender;
import com.nhnacademy.edu.springframework.messagesender.User;

public class SmsMessageSender implements MessageSender {


    @Override
    public void sendMessage(User user, String message) {
        System.out.printf("user: "+user.getPhoneNumber()+" message: "+ message);
        System.out.println();

    }
}
