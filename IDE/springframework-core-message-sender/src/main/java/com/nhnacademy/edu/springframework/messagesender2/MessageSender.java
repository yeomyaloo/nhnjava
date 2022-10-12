package com.nhnacademy.edu.springframework.messagesender2;

import com.nhnacademy.edu.springframework.messagesender.User;

public interface MessageSender {
    public void sendMessage(User user, String message);

}
