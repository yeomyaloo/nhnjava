package com.nhnacademy.edu.springframework.messagesender2;

import com.nhnacademy.edu.springframework.messagesender.User;

public class SmsMessageSender implements MessageSender{

    @Override
    public void sendMessage(User user, String message) {
        System.out.println("User phone-number: "+user.getPhoneNumber()+" message: "+ message);
    }
}
