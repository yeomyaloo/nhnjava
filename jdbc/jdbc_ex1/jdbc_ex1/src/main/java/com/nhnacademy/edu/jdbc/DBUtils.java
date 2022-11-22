package com.nhnacademy.edu.jdbc;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
    private static final DataSource DATASOURCE;

    static {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:mysql://133.186.211.156/nhn_academy_30");
        basicDataSource.setUsername("nhn_academy_30");
        basicDataSource.setPassword("dY)ydS7rUqApRwzo");
        basicDataSource.setInitialSize(4);
        basicDataSource.setMaxTotal(4);
//        basicDataSource.setTestOnBorrow(true);
//        basicDataSource.setValidationQuery("select 1");
//        basicDataSource.setMaxWaitMillis(1000L);


        DATASOURCE = basicDataSource;
    }

    private DBUtils(){}

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://133.186.151.141/nhn_academy_30", "nhn_academy_30", "dY)ydS7rUqApRwzo");
//            return DriverManager.getConnection("jdbc:mysql://133.186.151.141/nhnacademy_??", "nhnacademy_??", "test");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static DataSource getDataSource() {
        return DATASOURCE;
    }
}
