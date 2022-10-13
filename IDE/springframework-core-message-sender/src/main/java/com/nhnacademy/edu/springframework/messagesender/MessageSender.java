package com.nhnacademy.edu.springframework.messagesender;

public interface MessageSender {


    public void sendMessage(User user, String message);
    public boolean sendMessageBoolean(User user, String message);

}
