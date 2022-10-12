package com.nhnacademy.edu.springframework.messagesender;

import com.nhnacademy.edu.springframework.messagesender.service.SmsMessageSender;

public class MessageSenderService {


    private MessageSender smsmessageSender;
    private MessageSender emailMessageSender;


    public MessageSenderService() {
    }


    public void setSmsMessageSender(MessageSender smsmessageSender) {
        this.smsmessageSender = smsmessageSender;
    }

    public void setEmailMessageSender(MessageSender emailMessageSender) {
        this.emailMessageSender = emailMessageSender;
    }

    public MessageSenderService(MessageSender smsmessageSender,MessageSender emailMessageSender) {
        this.smsmessageSender = smsmessageSender;
        this.emailMessageSender = emailMessageSender;

    }

    public void doSendMessage() {
        smsmessageSender.sendMessage(new User("dad","dadasd"), "10101");
        emailMessageSender.sendMessage(new User("dad","dadasd"), "10101");
    }
}