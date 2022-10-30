package com.nhnacademy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyPageViewController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        return "myPage.jsp";
    }
}
