package com.nhnacademy.servlet.demo.servlet;

import com.nhnacademy.servlet.demo.Food;
import com.nhnacademy.servlet.demo.FoodStand;
import com.nhnacademy.servlet.demo.NhnMart;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "initServlet", urlPatterns = "/init")
public class InitServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {


        NhnMart mart = new NhnMart();
        FoodStand foodStand = mart.getFoodStand();

        ServletContext foodStandContext = req.getServletContext();

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");


        for (int i = 0; i < 2; i++){
            foodStand.add(new Food("양파",Integer.parseInt(getInitParameter("onion"))));
        }
        for(int i = 0; i < 5; i++){

            foodStand.add(new Food("파",Integer.parseInt(getInitParameter("greenOnion"))));

        }
        for (int i = 0; i<10; i++){
            foodStand.add(new Food("계란",Integer.parseInt(getInitParameter("egg"))));
        }

        for(int i = 0; i < 20; i++){
            foodStand.add(new Food("사과",Integer.parseInt(getInitParameter("apple"))));
        }



        try (PrintWriter out = resp.getWriter()){

            out.println("<html>");
            out.println("<head><title>cookie test</title></head>");
            out.println("<body>");

            out.println("<a href ='/foods'>/foods </a>");
            out.println("</body>");
            out.println("</html>");

            foodStandContext.setAttribute("foodStandContext", foodStand);

        }


    }
}
