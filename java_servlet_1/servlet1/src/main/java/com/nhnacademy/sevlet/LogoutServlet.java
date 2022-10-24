package com.nhnacademy.sevlet;

import java.io.IOException;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        //해당 세션이 있으면 해당 세션이 들어오고 없으면 null이 들어옴
        HttpSession session = req.getSession(false);

        if(Objects.nonNull(req.getSession())){
            session.invalidate();
        }

        resp.sendRedirect("login.html");


    }
}
