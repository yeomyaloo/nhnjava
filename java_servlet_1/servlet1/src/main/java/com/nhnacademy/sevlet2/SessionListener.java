package com.nhnacademy.sevlet2;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class SessionListener implements HttpSessionListener {


    private  int counter = 0;


    @Override
    public void sessionCreated(HttpSessionEvent se) {
        log.info("session = {}", ++counter);

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        log.info("");
    }
}
