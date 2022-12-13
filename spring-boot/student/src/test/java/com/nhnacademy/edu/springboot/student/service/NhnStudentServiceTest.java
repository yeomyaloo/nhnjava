package com.nhnacademy.edu.springboot.student.service;

import com.nhnacademy.edu.springboot.student.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NhnStudentServiceTest {

    @Autowired
    NhnStudentService nhnStudentService;


    @Test
    void testGetStudents() {

        List<Student> studentList = nhnStudentService.getStudents();

        assertThat(studentList).hasSize(2);
    }
}