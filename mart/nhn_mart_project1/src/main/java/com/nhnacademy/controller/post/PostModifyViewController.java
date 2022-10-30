package com.nhnacademy.controller.post;

import com.nhnacademy.controller.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostModifyViewController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        return "postModify.jsp";
    }
}
