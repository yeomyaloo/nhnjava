package com.nhnacademy.edu.jdbc_ex3.config;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {
    @Bean
    public DataSource dataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:mysql://133.186.211.156:3306/nhn_academy_50");
        basicDataSource.setUsername("nhn_academy_50");
        basicDataSource.setPassword("/B7owD_6TtCRJl6C");
        basicDataSource.setInitialSize(10);
        basicDataSource.setMaxTotal(20);

        return basicDataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}