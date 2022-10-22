package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.StudentService;
import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @Test
    void getPassedStudents() throws IOException {

        StudentService service = new DefaultStudentService();
        StudentService service2 = new DefaultStudentService();

        service.getPassedStudents();
        service2.getPassedStudents();

        Assertions.assertSame(service2,service);


    }

    @Test
    void getStudentsOrderByScore() throws IOException {

        StudentService service = new DefaultStudentService();
        StudentService service2 = new DefaultStudentService();

        service.getStudentsOrderByScore();
        service2.getStudentsOrderByScore();


        Assertions.assertEquals(service,service2);

    }
}