package com.nhnacademy.listener;


import com.nhnacademy.domain.User;
import com.nhnacademy.repository.ArrayUserRepository;
import com.nhnacademy.repository.ArrayPostRepository;

import com.nhnacademy.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Optional;


@Slf4j
@WebListener
public class WebappListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ServletContext servletContext = sce.getServletContext();

        UserRepository userRepository = new ArrayUserRepository();
        servletContext.setAttribute("userRepository", userRepository);


        /**해당 레포를 어플리케이션 실행 시에 객체 하나만을 등록해서 사용하기 위함(싱글톤..?) ->*
         * 이를 사용하기 위해서는 postRepository에 추가할 객체를 등록하는 컨트롤러에서 servletContext로 가져와서 Put작업을 진행
         * */
        servletContext.setAttribute("postRepository", new ArrayUserRepository());

        servletContext.setAttribute("boardId","0");

        /**
         * count 작업 시작
         * */
        String counterFileName = "counter.dat";
        String counterFilePath = "/WEB-INF/classes/" + counterFileName;

        int cnt = 0;

        try (DataInputStream dis = new DataInputStream(servletContext.getResourceAsStream(counterFilePath))){
            cnt = dis.readInt();
        } catch (IOException e) {
            log.error("", e);
        }
        servletContext.setAttribute("counter", cnt);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

        /**
         * counter 작업 destroy()
         * */
        String counterFileName = "counter.dat";
        String counterFilePath = "/WEB-INF/classes/" + counterFileName;


        int cnt = Optional.ofNullable(servletContext.getAttribute("counter")).
                map(Integer.class::cast)
                .orElse(0);

        try (OutputStream os = Files.newOutputStream(
                Paths.get(servletContext.getResource(counterFilePath).toURI()));
             DataOutputStream dos = new DataOutputStream(os)) {
            dos.writeInt(cnt);
        } catch (IOException | URISyntaxException ex) {
            log.error("", ex);
        }
    }

}

