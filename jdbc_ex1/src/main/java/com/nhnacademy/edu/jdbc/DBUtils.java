package com.nhnacademy.edu.jdbc;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

    private static final DataSource DATASOURCE;




    public static DataSource getDataSource() {
        return DATASOURCE;
    }

    static {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:mysql://133.186.211.156:3306/nhn_academy_50");
        basicDataSource.setUsername("nhn_academy_30");
        basicDataSource.setPassword("dY)ydS7rUqApRwzo");
        basicDataSource.setInitialSize(10);
        basicDataSource.setMaxTotal(2);
        basicDataSource.setTestOnBorrow(true);
        basicDataSource.setValidationQuery("select 1");

        DATASOURCE = basicDataSource;
    }

    public DBUtils() {
    }

    public static Connection getConnection() throws SQLException {

        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://133.186.151.141/nhn_academy_30",
                    "nhn_academy_30",
                    "dY)ydS7rUqApRwzo");
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
