package com.nhnacademy.servlet.demo.servlet;

import com.nhnacademy.servlet.demo.Food;
import com.nhnacademy.servlet.demo.NhnMart;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FoodStandServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");


        ServletContext servletContext = req.getServletContext();
        servletContext.getAttribute("foodName");

        NhnMart mart = new NhnMart();

        servletContext.setAttribute("foodName",new Food());



        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<head><title>cookie test</title></head>");
        out.println("<body>");

        out.println("<a href ='/foods' />");









    }
}
