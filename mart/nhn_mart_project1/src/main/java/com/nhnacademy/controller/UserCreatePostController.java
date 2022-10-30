package com.nhnacademy.controller;

import com.nhnacademy.domain.User;
import com.nhnacademy.domain.UserImp;
import com.nhnacademy.repository.ArrayUserRepository;
import com.nhnacademy.repository.UserRepository;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class UserCreatePostController implements Command {
   // UserRepository userRepository = ArrayUserRepository.getInstance();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String C_id = req.getParameter("create_id");
        String C_pwd = req.getParameter("create_password");
        String C_name = req.getParameter("create_name");
        String C_profile = req.getParameter("create_profile");



        if (C_id != null &&  C_pwd != null && C_name != null && C_profile != null){
            //repository.add(new UserImp(C_id,C_pwd,C_name,C_profile));

            User user = new UserImp(C_id,C_pwd,C_name,C_profile);


            ServletContext servletContext = req.getSession().getServletContext();
            UserRepository userRepository = (UserRepository) servletContext.getAttribute("userRepository");

            userRepository.add(user);

            req.getSession().setAttribute("create_user", "ok");
            return "login_ok.jsp";

        } else {
            req.getSession().setAttribute("create_user","fail");
            return "user_create.jsp";
        }
    }
}
