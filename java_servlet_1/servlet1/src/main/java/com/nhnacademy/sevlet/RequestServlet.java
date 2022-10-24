package com.nhnacademy.sevlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");

        try (PrintWriter out = resp.getWriter()) {
            out.println("locale=" + req.getLocale());
            out.println("parameter name=" + req.getParameter("name"));
            out.println("content type=" + req.getContentType());
            out.println("content length=" + req.getContentLengthLong());
            out.println("method=" + req.getMethod());
            out.println("path info=" + req.getPathInfo());
            out.println("servlet path=" + req.getServletPath());
            out.println("request uri=" + req.getRequestURI());
            out.println("request url=" + req.getRequestURL());
            out.println("User-Agent header=" + req.getHeader("User-Agent"));
        } catch (IOException ex) {
            log.error("", ex);
        }
    }
}