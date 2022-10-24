package com.nhnacademy.sevlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadCookieServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {


        /*Cookie localeCookie = getCookie(req, "locale");
        String locale = localeCookie.getValue();

        String message = ResourceBundle.getBundle("message", new Locale(locale)).getString("hello");


        resp.setContentType("text/plain");


        public static Cookie getCookie(HttpServletRequest req, String name) {

            return Optional.ofNullable(req.getCookies())
                .flatMap(cookies -> Arrays.stream(cookies)
                    .filter(c -> c.getName().equals(name))
                    .findFirst()).orElse(null);
        }

    }*/
}}
