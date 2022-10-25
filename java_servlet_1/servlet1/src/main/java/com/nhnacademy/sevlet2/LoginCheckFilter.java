package com.nhnacademy.sevlet2;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter {

    private Set<String> excludeUrls = new HashSet<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String urls = filterConfig.getInitParameter("exclude-urls");


        //string  -> string array -> map -> set으로 저장 ~
        excludeUrls =
            Arrays.stream(urls.split("\n")).map(String::trim).collect(Collectors.toSet());

        System.out.println(excludeUrls);
    }

    //제어를 다음으로 넘길지 말지에 따라서 달라짐

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
        FilterChain filterChain) throws IOException, ServletException {
        HttpSession session =((HttpServletRequest)request).getSession(false);

        if(Objects.isNull(session)){

            if(excludeUrls.contains(((HttpServletRequest) request).getRequestURI())) {
                filterChain.doFilter(request,response);

            } else{
                //세션이 없다면 다음으로 넘기지 않고 해당 위치에서 요청을 끝맺으면 된다.
                ((HttpServletResponse) response).sendRedirect("/login.html");
            }
        }else {

            //세션이 있다면 다음으로 넘겨주면 된다.
            filterChain.doFilter(request,response);
        }
    }
}

