package com.nhnacademy.servlet;

import com.nhnacademy.domain.MapStudentRepository;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class WebAppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        //repo를 해당 이벤트가 발생했을 때 가져와서 넣어주면 된다
        servletContext.setAttribute("studentRepository", new MapStudentRepository());
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
    }
}
