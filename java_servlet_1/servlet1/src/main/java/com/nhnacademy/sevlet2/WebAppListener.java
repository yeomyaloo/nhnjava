package com.nhnacademy.sevlet2;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class WebAppListener implements ServletContextListener {


    //event를 일으키는 애를 가져와서 해당 attribute를 넣어주는 식의 작업
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

        String counterFileName = servletContext.getInitParameter("counterFileName");
        String counterFilePath = "/WEB-INF/classes" + counterFileName;


        int counter = 0;
        try(DataInputStream dis = new DataInputStream(servletContext.getResourceAsStream(counterFilePath));
        ) {
            counter = dis.readInt();
        } catch (Exception e) {
                log.error("", e);
        }

        servletContext.setAttribute("counter", counter);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

        String counterFileName = servletContext.getInitParameter("counterFileName");
        String counterFilePath = "/WEB-INF/classes/" + counterFileName;

        int counter = (int) servletContext.getAttribute("counter");

        try (OutputStream os = Files.newOutputStream(Paths.get(servletContext.getResource(counterFilePath).toURI()));
            DataOutputStream dos = new DataOutputStream(os)){
            dos.writeInt(counter);
        } catch (IOException | URISyntaxException ex){

            log.error("",ex);
        }

        /*

        File file =new File(servletContext.getResource(counterFilePath).toURI());
        FileOutputStream fos = new FileOutputStream(file);
        DataOutputStream dos = new DataOutputStream(fos)
        */


    }
}
