package com.nhnacademy.controller;

import com.nhnacademy.domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginPostController implements Command {

    private String idInitParam;
    private String pwdInitParam;

    public LoginPostController(String idInitParam, String pwdInitParam) {
        this.idInitParam = idInitParam;
        this.pwdInitParam = pwdInitParam;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp){


        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");



        if (id != null && pwd != null && idInitParam.equals(id) && pwdInitParam.equals(pwd)) {
            HttpSession session = req.getSession();
//
//            User user = new User(id, pwd, " ");
//            session.setAttribute("id", user);

            session.setAttribute("role", "USER");
            session.setAttribute("id", id);
            session.setAttribute("is_login_fail","user_ok");
            return "login_ok.do";

        } else if (id != null && pwd != null && id.equals("admin") && pwd.equals("12345")) {
            HttpSession session = req.getSession();

//            User user = new User("admin","12345","ADMIN");
//            session.setAttribute("id", user);

            session.setAttribute("role", "ADMIN");
            session.setAttribute("id", "관리자");
            session.setAttribute("is_login_fail", "admin_ok");

            return "login_ok.do";
        }else {
            req.getSession().setAttribute("is_login_fail", "fail");
            return "index.jsp";
        }

    }


}
