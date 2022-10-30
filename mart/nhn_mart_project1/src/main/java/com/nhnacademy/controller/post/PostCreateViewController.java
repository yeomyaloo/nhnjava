package com.nhnacademy.controller.post;

import com.nhnacademy.controller.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostCreateViewController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        return "postCreate.jsp";
    }
}
