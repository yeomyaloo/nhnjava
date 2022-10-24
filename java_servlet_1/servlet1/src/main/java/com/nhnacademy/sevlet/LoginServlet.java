package com.nhnacademy.sevlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String initParamId = getServletConfig().getInitParameter("id");
        String initParamPwd =getServletConfig().getInitParameter("pwd");

        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");



        if(initParamId.equals(id) && initParamPwd.equals(pwd)){
            HttpSession session = request.getSession();
            session.setAttribute("id", id);

        }

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        //세션이 없으면 null 반환 있으면 session 반환
        HttpSession session = req.getSession(false);

        if(Objects.isNull(session)){
            resp.sendRedirect("/login.html");

        } else{
            resp.setContentType("text/html");
            resp.getWriter().println("login success: id = " + session.getAttribute("id"));



        }

    }

}
