package com.nhnacademy.servlet.servlet_start;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class TestServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.getWriter().println("hello world");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res)
        throws ServletException, IOException {
        log.info("service() called");
        super.service(req, res);


    }

    @Override
    public void destroy() {
        log.info("destroy() called");
        super.destroy();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        log.info("init() called");

        super.init(config);
    }
}
