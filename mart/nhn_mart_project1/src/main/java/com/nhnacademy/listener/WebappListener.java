package com.nhnacademy.listener;


import com.nhnacademy.repository.ArrayUserRepository;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import java.lang.annotation.Annotation;

@WebListener
public class WebappListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("userRepository", new ArrayUserRepository());

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
