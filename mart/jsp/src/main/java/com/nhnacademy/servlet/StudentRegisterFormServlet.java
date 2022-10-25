package com.nhnacademy.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet(name="studentRegisterFormServlet",urlPatterns = "/student/registerForm")
public class StudentRegisterFormServlet implements Command {



/*

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        req.setAttribute("view", "/studentRegister.jsp");
    }
*/

    @Override
    public String excute(HttpServletRequest request, HttpServletResponse response) {
        return  "/studentRegister.jsp";
    }
}
