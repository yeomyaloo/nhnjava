package com.nhnacademy.edu.jpa.dataSource;


import com.fasterxml.jackson.annotation.JacksonInject;
import com.nhnacademy.edu.jpa.config.RootConfig;
import com.nhnacademy.edu.jpa.config.WebConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import javax.swing.*;
import java.sql.Connection;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)
})
public class testDataSource {


    @JacksonInject
    private DataSource dataSource;
    @Test
    public void testDS() throws Exception{

        try(Connection con = dataSource.getConnection()){
            System.out.println("dataSource설정 성공");
            System.out.println(con);
        }catch(Exception e){
            System.out.println("실패");
            e.printStackTrace();
        }
    }
}
