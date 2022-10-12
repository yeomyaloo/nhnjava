package com.nhnacademy.edu.springframework.messagesender.xml;

import com.nhnacademy.edu.springframework.messagesender.MessageSender;
import com.nhnacademy.edu.springframework.messagesender.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlMain {

    public static void main(String[] args) {

        //실행
        String location = "classpath:/beans.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(location);


        //객체 생성
        MessageSender emailMessageSender = context.getBean("emailMessageSender", MessageSender.class);
        MessageSender smsMessageSender = context.getBean("smsMessageSender", MessageSender.class);


        //사용
        emailMessageSender.sendMessage(new User("ddd@gmail.com","010-000-0000"),"dadsad");
        smsMessageSender.sendMessage(new User("ddd@gmail.com","010-000-0000"),"dadsad");

        //사용 후 종료 ~> Spring Bean도 종료
        context.close();
    }



}
