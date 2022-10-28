package com.nhnacademy.controller;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;


@Slf4j
public class LogoutPostController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            HttpSession session = req.getSession(false);
            if (Objects.nonNull(session)){
                session.invalidate();
            }
        } catch (Exception e){
            log.error("{}", e);
        }
        return "index.jsp";
    }
}
