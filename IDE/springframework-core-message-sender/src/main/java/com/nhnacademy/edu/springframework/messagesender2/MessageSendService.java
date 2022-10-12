package com.nhnacademy.edu.springframework.messagesender2;

import com.nhnacademy.edu.springframework.messagesender.User;

public class MessageSendService {

    private final MessageSender messageSender;

    //해당 생성자로 생성하면 넣어주는 객체를 사용하게 된다.
    public MessageSendService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void doSendMessage(){
        messageSender.sendMessage(new User("email@naver.com","010-000-0000"),"message~");
    }
}
