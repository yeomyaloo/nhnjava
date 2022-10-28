package com.nhnacademy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginOkFormController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        return "login_ok.jsp";
    }
}
