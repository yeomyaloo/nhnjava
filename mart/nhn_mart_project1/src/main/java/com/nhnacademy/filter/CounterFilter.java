package com.nhnacademy.filter;

import com.nhnacademy.controller.Command;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName = "counterFilter", urlPatterns = "/*")
public class CounterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        ServletContext servletContext = request.getServletContext();
        int count = (int) servletContext.getAttribute("counter");

        request.setAttribute("counter", ++count);
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }

}