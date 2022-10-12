package com.nhnacademy.edu.springframework.messagesender2;

import com.nhnacademy.edu.springframework.messagesender.User;

public class EmailMessageSender implements MessageSender{

    @Override
    public void sendMessage(User user, String message) {
        System.out.println("User Email: "+user.getEmail()+" message: "+ message);
    }
}
