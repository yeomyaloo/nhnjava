package com.nhnacademy.controller;

import com.nhnacademy.domain.User;
import com.nhnacademy.domain.UserImp;
import com.nhnacademy.repository.UserRepository;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class UserModifyPostController implements Command {


    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        ServletContext servletContext = req.getSession().getServletContext();
        UserRepository userRepository = (UserRepository) servletContext.getAttribute("userRepository");


        String modifyId = req.getParameter("modify_id");
        String modifyPwd = req.getParameter("modify_password");
        String modifyName = req.getParameter("modify_name");
        String modifyPro = req.getParameter("modify_profile");


        List<User> list = userRepository.getUsers();

        for (User user : list) {
            if (user.getId().equals(modifyId)){
                user.setId(modifyId);
                user.setPassword(modifyPwd);
                user.setName(modifyName);
                user.setProfileFileName(modifyPro);
            } else {
                req.getSession().setAttribute("modify_user", "fail");
                return "user_modify.jsp";
            }
        }
        req.getSession().setAttribute("modify_user","ok");
        return "login_ok.jsp";
    }
}
