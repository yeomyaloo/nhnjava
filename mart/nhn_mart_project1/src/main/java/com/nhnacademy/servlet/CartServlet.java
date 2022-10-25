package com.nhnacademy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="cartServlet", urlPatterns = "/cart")
public class CartServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        ServletContext servletContext = getServletContext();

        Integer onionCnt = (Integer) servletContext.getAttribute("onionCnt");

        Integer greenOnionCnt = (Integer) servletContext.getAttribute("greenOnionCnt");

        Integer appleCnt = (Integer) servletContext.getAttribute("apple");

        Integer eggCnt = (Integer) servletContext.getAttribute("egg");

        int totalPrice = (onionCnt*1000) + (greenOnionCnt*500) + (eggCnt *2000) + (appleCnt*2000);

        try(PrintWriter out = resp.getWriter()) {
            out.println("<html><body>"
                + "<h1>현재 장바구니 목록</h1>"
                + "<div>양파 개수: " + onionCnt
                + "</div>"
                + "<div>파 개수: " + greenOnionCnt
                + "</div>"
                + "<div>사과 개수: " + appleCnt
                + "</div>"
                + "<div>계란 개수: " + eggCnt
                + "</div></br>"
                + "<div> 현재 장바구니에 담긴 상품 가격: "
                + totalPrice
                + "</div>"
                + "</body></html>");
        }catch (Exception e){
        }
    }
}
