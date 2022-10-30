package com.nhnacademy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserModifyViewController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        return "user_modify.jsp";
    }
}
