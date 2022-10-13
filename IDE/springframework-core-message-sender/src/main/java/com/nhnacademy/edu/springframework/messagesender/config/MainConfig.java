package com.nhnacademy.edu.springframework.messagesender.config;


import com.nhnacademy.edu.springframework.messagesender.MessageSender;
import com.nhnacademy.edu.springframework.messagesender.MessageSenderService;
import com.nhnacademy.edu.springframework.messagesender.service.EmailMessageSender;
import com.nhnacademy.edu.springframework.messagesender.service.SmsMessageSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan(basePackages = {"com.nhnacademy.edu.springframework.messagesender"})
@EnableAspectJAutoProxy(proxyTargetClass = true)

//@ImportResource("classpath:/beans.xml") @ImportResource() ~> 사용하면 빈설정 안 해줘도 됨
public class MainConfig {

//    @Bean
//    public MessageSender emailMessageSender(){
//        return new EmailMessageSender();
//    }
//
//    @Bean
//    public MessageSender smsMessageSender(){
//        return new SmsMessageSender();
//    }
/*
    @Bean
    public MessageSender emailMessageSender(){
        return new EmailMessageSender();
    }


    @Bean
    public MessageSender smsMessageSender(){
        return new SmsMessageSender();
    }

    @Bean
    public MessageSenderService messageSenderService(){
        return new MessageSenderService(smsMessageSender());
    }
*/







}
