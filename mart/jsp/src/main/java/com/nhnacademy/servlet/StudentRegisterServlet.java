package com.nhnacademy.servlet;

import com.nhnacademy.domain.MapStudentRepository;
import com.nhnacademy.domain.Student;
import com.nhnacademy.domain.StudentRepository;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet(name ="studentRegisterServlet", urlPatterns = "/student/register")
public class StudentRegisterServlet implements Command {

    @Override
    public String excute(HttpServletRequest req, HttpServletResponse resp) {


        //req.setCharacterEncoding("UTF-8");
        Student student = new Student(
            req.getParameter("id"),
            req.getParameter("name"),
            Integer.parseInt(req.getParameter("age")));

        StudentRepository studentRepository = (StudentRepository) req.getServletContext().getAttribute("studentRepository");

        studentRepository.addStudent(student);

        //resp.sendRedirect("/student/view?id=" + student.getId());

        return "redirect:/student/view.do?id=" +student.getId();
    }

}
