package com.nhnacademy.edu.springframework.messagesender;

import com.nhnacademy.edu.springframework.messagesender.config.MainConfig;
import com.nhnacademy.edu.springframework.messagesender.service.SmsMessageSender;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigMain {

    public static void main(String[] args) {


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            MainConfig.class);

        //SmsMessageSender smsSenderMessage = context.getBean("smsMessageSender",SmsMessageSender.class);
        // smsSenderMessage.sendMessage(new User("adasd@ndadasda.csd", "010-100-0000"), "message~");

        MessageSender emailMessageSender = MessageSender.class.cast(context.getBean("emailMessageSender"));
        MessageSender smsMessageSender = MessageSender.class.cast(context.getBean("smsMessageSender"));


        User user = new User("hi@naver.com","010-111-1111");

        smsMessageSender.sendMessage(new User("SMS EMAIL", "010-1111-1111"), "SMS ~");

        emailMessageSender.sendMessage(new User("EMAIL", "010-2222-2222"), "EMAIL ~");

        context.close();
    }

}
