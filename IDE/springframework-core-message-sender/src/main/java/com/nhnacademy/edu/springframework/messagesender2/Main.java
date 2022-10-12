package com.nhnacademy.edu.springframework.messagesender2;

import com.nhnacademy.edu.springframework.messagesender.MessageSenderService;
import com.nhnacademy.edu.springframework.messagesender.User;

public class Main {

    public static void main(String[] args) {
        MessageSender sender = new EmailMessageSender();

        sender.sendMessage(new User("dasduasdu@naver.com", "010-000-0000"), "000");


   }
}
