package com.nhnacademy.sevlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;


public class BeautifySevlete extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        String html = req.getParameter("html");

        resp.setContentType("text/html");
        resp.getWriter().println(Jsoup.parse(html));


    }
}
