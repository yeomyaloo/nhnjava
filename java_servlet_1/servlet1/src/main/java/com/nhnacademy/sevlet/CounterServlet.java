package com.nhnacademy.sevlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CounterServlet extends HttpServlet {

    private  int counter;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        //init에서 넘겨받은 config를 여기서 counter를 증가시켜주면 된다.
        resp.getWriter().println(++counter);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        counter = Integer.parseInt(config.getInitParameter("cnt"));
    }

}
