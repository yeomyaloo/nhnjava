package com.nhnacademy.servlet;


import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*", initParams = {
        @WebInitParam(name = "excludedUrls", value = "/\n"
                + "index.jsp\n"
                + "login_ok.jsp\n"
        )
})
@Slf4j
public class LoginCheckFilter implements Filter {

    List<String> excludedUrls = new ArrayList<>();


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String urls = filterConfig.getInitParameter("excludedUrls");

        log.error("excludedUrls ={}", urls);
        this.excludedUrls = Arrays.stream(urls.split("\n"))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        String requestUri = ((HttpServletRequest)servletRequest).getRequestURI();
        if (excludedUrls.contains(requestUri)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            HttpSession session = ((HttpServletRequest) servletRequest).getSession(false);
            if (Objects.isNull(session)) {
                ((HttpServletResponse) servletResponse).sendRedirect("/login.html");
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
    }


    @Override
    public void destroy() {

    }

}

