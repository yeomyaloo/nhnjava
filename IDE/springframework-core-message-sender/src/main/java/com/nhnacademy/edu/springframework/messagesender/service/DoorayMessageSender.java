package com.nhnacademy.edu.springframework.messagesender.service;

import com.nhn.dooray.client.DoorayHook;
import com.nhn.dooray.client.DoorayHookSender;
import com.nhnacademy.edu.springframework.messagesender.MessageSender;
import com.nhnacademy.edu.springframework.messagesender.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DoorayMessageSender implements MessageSender {


    @Autowired
    public DoorayMessageSender() {

        System.out.println("----------------------dooray Constructor----------------------");
    }

    @Override
    public void sendMessage(User user, String message) {

    }

    @Override
    public boolean sendMessageBoolean(User user, String message) {
        new DoorayHookSender(new RestTemplate(), "https://hook.dooray.com/services/3036349505739914786/3371740733259172017/cdnzcggTTWmx2GtusEMUJw")
            .send(DoorayHook.builder()
                .botName("염휘주")
                .text("$..")
                .build());
        return true;
    }

}
