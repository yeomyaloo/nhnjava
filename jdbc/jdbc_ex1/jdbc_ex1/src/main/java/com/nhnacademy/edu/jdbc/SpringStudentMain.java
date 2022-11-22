package com.nhnacademy.edu.jdbc;

import com.nhnacademy.edu.jdbc.config.MainConfig;
import com.nhnacademy.edu.jdbc.domain.Student;
import com.nhnacademy.edu.jdbc.spring.service.StudentService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

public class SpringStudentMain {

    private static final Log log = LogFactory.getLog(Main.class);

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class)) {
            StudentService bean = ctx.getBean(StudentService.class);

            log.info("1 student");
            log.info(bean.getStudent(1L));
            log.info("all students");
            bean.getAllStudents().forEach(log::info);

            bean.insertAndDelete(new Student(5L, "학생5", new Date()));
            log.info("after insert and delete");
            bean.getAllStudents().forEach(log::info);

            try {
                bean.insertAndDelete(new Student(10L, "학생5", new Date()));
            }catch (Exception e) {}
            log.info("after insert and delete For Rollback");
            bean.getAllStudents().forEach(log::info);

            try {
                bean.insertAndDeleteWithoutTransaction(new Student(10L, "학생5", new Date()));
            }catch (Exception e) {}
            log.info("after insert and delete For Rollback");
            bean.getAllStudents().forEach(log::info);
        }
    }

}