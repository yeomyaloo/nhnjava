package com.nhnacademy.edu.jdbc_ex3;


import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


@WebServlet(urlPatterns = "/jdbc", name = "jdbcConnectionServlet")
public class JdbcConnectionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataSource dataSource = getDataSource();
        try (Connection connection = dataSource.getConnection();

             Statement statement = connection.createStatement()) {


            ResultSet resultSet = statement.executeQuery("select * from JdbcTeachers");
            while (resultSet.next()) {
                resp.setCharacterEncoding("utf-8");
                resp.setContentType("text/html");
                resp.getWriter().println("==>" + resultSet.getLong(1));
                resp.getWriter().println("==>" + resultSet.getString(2));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        resp.flushBuffer();
    }

    private DataSource getDataSource() {
        try {
            InitialContext initialContext = new InitialContext();
            return (DataSource) initialContext.lookup("java:comp/env/jdbc/test");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }
}
