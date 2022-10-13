package com.nhnacademy.edu.springframework.messagesender.aop;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CommonPointcuts {
    @Pointcut("execution(* com.nhnacademy.edu.springframework.messagesender.MessageSender.sendMessage())")
    public void messageService(){

    }
}
