package com.nhnacademy.servlet;

import com.nhnacademy.domain.Student;
import com.nhnacademy.domain.StudentRepository;
import java.io.IOException;
import java.util.Objects;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class StudentViewServlet implements Command {


    @Override
    public String excute(HttpServletRequest req, HttpServletResponse resp) {
        ServletContext servletContext = req.getServletContext();
        StudentRepository studentRepository = (StudentRepository) servletContext.getAttribute("studentRepository");

        String id = req.getParameter("id");
        Student student = studentRepository.get(id);

        //없는 학번 조회?
        if (Objects.isNull(student)){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        } else {
            RequestDispatcher rd = req.getRequestDispatcher("/studentView.jsp");
            rd.forward(req, resp);

            req.setAttribute("view", "/studentView.jsp");
        }

        return "/studentView.jsp";
    }
}

