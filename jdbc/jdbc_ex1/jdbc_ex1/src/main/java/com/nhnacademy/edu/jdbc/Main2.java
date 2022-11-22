package com.nhnacademy.edu.jdbc;

import java.sql.Connection;
import java.sql.SQLException;


// 실습과제 ... 진행중 
public class Main2 {
    public static void main(String[] args) throws SQLException{
        Connection connection = null;
        try {
            connection = DBUtils.getDataSource().getConnection();
            connection.setAutoCommit(false);

            //콤틴 추가
            //HTTP 과목 추가
            // 콤틴- HTTP course 추가

            connection.commit();
        }catch (SQLException e) {
            connection.rollback();
        }finally {
            connection.close();
        }
    }
}
