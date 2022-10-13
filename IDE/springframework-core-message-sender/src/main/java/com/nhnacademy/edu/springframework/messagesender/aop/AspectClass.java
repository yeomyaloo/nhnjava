package com.nhnacademy.edu.springframework.messagesender.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StopWatch;


@Aspect
public class AspectClass {


    @Pointcut("@annotation(com.nhnacademy.edu.springframework.messagesender.aop.Timer)")
    private void timer(){};

    @Around("com.nhnacademy.edu.springframework.messagesender.aop.CommonPointcuts.messageService()")
    public Object messageSender(ProceedingJoinPoint pjp) throws Throwable {

        StopWatch stopWatch = new StopWatch("Logger");

        stopWatch.start();
        Object retVal = pjp.proceed();

        stopWatch.stop();

        System.out.println(stopWatch.prettyPrint());

        return retVal;
    }
}
