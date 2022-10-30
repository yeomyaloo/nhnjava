package com.nhnacademy.controller;

import com.nhnacademy.domain.User;
import com.nhnacademy.repository.UserRepository;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

public class UserDeletePostController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        ServletContext servletContext = req.getSession().getServletContext();
        UserRepository userRepository = (UserRepository) servletContext.getAttribute("userRepository");

        String deleteId = req.getParameter("delete_id");

        List<User> list = userRepository.getUsers();
        req.getSession().setAttribute("delete_user", "form");


        for (User user : list) {
            if (user.getId().equals(deleteId)){
                list.remove(user);
                req.getSession().setAttribute("delete_user", "ok");
                return "login_ok.jsp";
            } else {
                req.getSession().setAttribute("delete_user", "fail");
            }
        }
        return "user_delete.jsp";
    }
}