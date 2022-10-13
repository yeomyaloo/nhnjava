package com.nhnacademy.edu.springframework.messagesender.service;

import com.nhnacademy.edu.springframework.messagesender.MessageSender;
import com.nhnacademy.edu.springframework.messagesender.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component
public class SmsMessageSender implements MessageSender {


    public SmsMessageSender() {
        System.out.println("SmsMessageSender 생성중...");
    }

    public void close(){
        System.out.println("----------------------- SMS close --------------------");
    }

    @Override
    public void sendMessage(User user, String message) {

        System.out.println("-----------SmsMessageSender-------------");
        System.out.printf("user: "+user.getPhoneNumber()+" message: "+ message);
        System.out.println();

    }

    @Override
    public boolean sendMessageBoolean(User user, String message) {
        return false;
    }


}
