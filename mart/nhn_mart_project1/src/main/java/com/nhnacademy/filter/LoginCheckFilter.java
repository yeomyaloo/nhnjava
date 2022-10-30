package com.nhnacademy.filter;


import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;
import java.util.logging.LogRecord;


@Slf4j
public class LoginCheckFilter implements Filter {

    private static final String[] whiteList = {"/", "/login.do", "index.jsp"};


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init login filter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }

}
