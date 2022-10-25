package com.nhnacademy;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet(name ="loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        String initParamId = getServletConfig().getInitParameter("id");
        String initParamPwd = getServletConfig().getInitParameter("pwd");

        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");


        if (initParamId.equals(id) && initParamPwd.equals(pwd)) {
            HttpSession session = req.getSession();
            session.setAttribute("id", id);
            resp.sendRedirect("/login");
        } else {
            resp.sendRedirect("/login.html");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (Objects.isNull(session)) {
            resp.sendRedirect("/login.html");
        } else {
            resp.setContentType("text/html");

            try (PrintWriter out = resp.getWriter()) {
                out.println("login success: id=" + session.getAttribute("id") + "<br />");
                out.println("<a href='/logout'>logout</a>");
            } catch (IOException ex) {
                log.error("", ex);
            }
        }
    }

}
