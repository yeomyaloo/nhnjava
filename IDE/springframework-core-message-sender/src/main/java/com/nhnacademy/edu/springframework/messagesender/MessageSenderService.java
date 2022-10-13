package com.nhnacademy.edu.springframework.messagesender;

import com.nhnacademy.edu.springframework.greeting2.Greeter;
import com.nhnacademy.edu.springframework.messagesender.service.SmsMessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class MessageSenderService {

    private MessageSender messageSender;
/*

    @Value("${from}")
    private String name;
*/


    public void setMessageSender(
        MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @Autowired
    public MessageSenderService(MessageSender doorayMessageSender) {
        System.out.println("-----------------Constructor Injection--------------------");
        this.messageSender = doorayMessageSender;
    }



    public boolean sendMessage(){

        return true;
    }

    public void doSendMessage() {
        messageSender.sendMessage(new User("dad","dadasd"), "10101");
    }
}