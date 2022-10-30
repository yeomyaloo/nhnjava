package com.nhnacademy.servlet;

import com.nhnacademy.controller.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name = "frontServlet", urlPatterns = "*.do")
public class FrontServlet extends HttpServlet {
    private static final String REDIRECT_PREFIX = "redirect:";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 공통 처리 - 응답 content-type, character encoding 지정.
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        try {
            Command command  = resolveCommand(req.getServletPath(), req.getMethod());
            String view = command.execute(req, resp);
            if (view.startsWith(REDIRECT_PREFIX)) {
                // redirect:로 시작하면 redirect 처리.
                resp.sendRedirect(view.substring(REDIRECT_PREFIX.length()));
            } else {
                // view를 뿌려주는 작업은 이곳에서 진행
                resp.sendRedirect(view);
            }
        } catch (Exception ex) {
            // 에러가 발생한 경우는 error page로 지정된 /error.jsp에게 view 처리를 위임.

            req.setAttribute("exception", ex);

            RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
            rd.forward(req, resp);
        }
    }

    private Command resolveCommand(String servletPath, String method) {
        Command command = null;

        if ("/login.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new LoginPostController("hi", "123");

        } else if("/login_ok.do".equals(servletPath) && "GET".equalsIgnoreCase(method)){
            command = new LoginOkFormController();
        } else if("/logout.do".equals(servletPath) && "POST".equalsIgnoreCase(method)){
            command = new LogoutPostController();
        } else if("/find_user.do".equals(servletPath) && "GET".equalsIgnoreCase(method)){
            command = new UserListFormController();
        } else if("/create_user.do".equals(servletPath) && "GET".equalsIgnoreCase(method)){
            command = new UserCreateFormController();
        } else if("/create_user.do".equals(servletPath) && "POST".equalsIgnoreCase(method)){
            command = new UserCreatePostController();
        }



//        } else if ("/cart.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
//            command = new CartUpdateController();
//
//        } else if ("/login.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
//            command = new LoginFormController();
//
//        } else if ("/login.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
//            command = new LoginProcessingController("admin", "12345");
//
//        } else if ("/foods.do".equals(servletPath) && "GET".equalsIgnoreCase(method)){
//            command  = new FoodListController();
//        }

        return command;

    }
}