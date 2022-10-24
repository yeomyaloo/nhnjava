package com.nhnacademy.sevlet;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class ServletContextServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        ServletContext servletContext =getServletConfig().getServletContext();
        PrintWriter printWriter = resp.getWriter();

        try{
            printWriter.println(servletContext.getContextPath());
            printWriter.println(servletContext.getMajorVersion());
            printWriter.println(servletContext.getMinorVersion());
            printWriter.println(servletContext.getEffectiveMajorVersion());
            printWriter.println(servletContext.getEffectiveMinorVersion());
            printWriter.println("/servletContext");
            printWriter.println(servletContext.getInitParameter("url"));



        }catch (Exception e){
            log.error("",e);
        }





    }


}
