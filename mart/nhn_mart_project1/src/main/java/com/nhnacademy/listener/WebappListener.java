package com.nhnacademy.listener;


import com.nhnacademy.domain.User;
import com.nhnacademy.repository.ArrayUserRepository;
import com.nhnacademy.repository.ArrayPostRepository;

import com.nhnacademy.repository.UserRepository;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import java.lang.annotation.Annotation;
import java.util.Objects;

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


        User user = (User) servletContext.getAttribute("newUser");




    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
