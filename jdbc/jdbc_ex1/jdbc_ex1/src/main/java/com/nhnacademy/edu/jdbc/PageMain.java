package com.nhnacademy.edu.jdbc;

import com.nhnacademy.edu.jdbc.DBUtils;
import com.nhnacademy.edu.jdbc.domain.Page;
import com.nhnacademy.edu.jdbc.domain.Teacher;
import com.nhnacademy.edu.jdbc.domain.TeacherRepository;
import com.nhnacademy.edu.jdbc.repository.PsmtTeacherRepository;

import java.sql.Connection;
import java.sql.SQLException;

public class PageMain {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        try {
            connection = DBUtils.getDataSource().getConnection();

            TeacherRepository teacherRepository = new PsmtTeacherRepository();
            Page<Teacher> teacherPage = teacherRepository.findAll(connection, 2, 5);
            teacherPage
                    .getContent()
                    .forEach(System.out::println);

            System.out.println("total count:" + teacherPage.getTotalCount());

        }finally {
            connection.close();
        }
    }
}