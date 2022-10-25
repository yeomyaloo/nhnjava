package com.nhnacademy.servlet;

import com.nhnacademy.domain.Food;
import com.nhnacademy.repository.FoodRepository;
import com.nhnacademy.repository.FoodRepositoryImp;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="foodListServlet", urlPatterns = "/foods")
public class FoodListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        FoodRepository repository = new FoodRepositoryImp();
        FoodRepository foodRepository = (FoodRepository) getServletContext().getAttribute("foodRepository");

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");


        int onion = 2;
        int egg = 5;
        int greenOnion = 10;
        int apple = 20;



        try(PrintWriter out = resp.getWriter()) {
            out.println("<html> <head> <title>FOOD LIST</title> </head> <body>");
            out.println("<h1>현재 재고</h1></br>");
            out.println("<div> 양파 현재 개수 : " + onion + "</div>");
            out.println("<div> 계란 현재 개수 :" + egg + "</div>");
            out.println("<div> 파 현재 개수 :" + greenOnion + "</div>");
            out.println("<div> 사과 현재 개수 :" + apple + "</div>");
            out.println("<div>구매하실 수량을 작성해주세요.</div>");
            out.println("<div>단, 현재 수량보다 구매수량이 많다면 구매는 불가합니다.</div>");
            out.println(
                "<form method =\"post\" action = \"/cart\"> <label>양파 : </label><input type =\"text\" name =\"onionCnt\">");
            out.println("<label>계란 : </label> <input type =\"text\" name =\"eggCnt\">");
            out.println("<label>파 : </label> <input type =\"text\" name =\"greenOnionCnt\">");
            out.println("<label>사과 : </label> <input type =\"text\" name =\"appleCnt\">");
            out.println("<button type=\"submit\" />장바구니에 담기</button></form></body> </html>");


        } catch (Exception e){

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        Integer onion = Integer.valueOf(req.getParameter("onionCnt"));
        Integer greenOnion = Integer.valueOf(req.getParameter("greenOnionCnt"));
        Integer egg = Integer.valueOf(req.getParameter("eggCnt"));
        Integer apple = Integer.valueOf(req.getParameter("appleCnt"));

        PrintWriter out = resp.getWriter();

        if (onion < 2 || greenOnion < 10 || egg < 5 || apple < 20){
            out.println("<html><body><head><title>FOOD LIST</title><head>"
                + "<div>구매하고자하는 개수가 준비 수량을 넘었습니다.</div>"
                + "</body></html>");

            resp.sendRedirect("/foods");
        }else {
            req.setAttribute("onionCnt", 2 - onion.intValue());
            req.setAttribute("eggCnt", 5 - egg.intValue());
            req.setAttribute("greenOnionCnt", 10 - greenOnion.intValue());
            req.setAttribute("appleCnt", 20 - apple.intValue());

            resp.sendRedirect("/cart");
        }
    }
}
