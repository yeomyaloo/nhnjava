package com.nhnacademy.edu.springframework.project.AOP;


import java.net.InetAddress;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
@Slf4j
public class AspectClass {

    @Around("@annotation(TestAnnotation)")
    public void test(ProceedingJoinPoint pjp, TestAnnotation testAnnotation, String className, String methodName){

        StopWatch clock = new StopWatch();

        long start = System.currentTimeMillis();
        try {

            clock.start();

        }finally {
            clock.stop();
            long stop = System.currentTimeMillis();
            System.out.print("[ " + className + " ] . [ " + methodName + " ] [ " + (stop -start) + "]");
        }
    }
}
