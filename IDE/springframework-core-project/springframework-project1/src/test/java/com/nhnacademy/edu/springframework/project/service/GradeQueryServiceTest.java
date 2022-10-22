package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.CsvScores;
import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Scores;
import com.nhnacademy.edu.springframework.project.repository.Students;
import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GradeQueryServiceTest {

    @Test
    void getScoreByStudentName() throws IOException {

        GradeQueryService service = new DefaultGradeQueryService();

        service.getScoreByStudentName("A");

        Assertions.assertSame(service,true);

    }

    @Test
    void getScoreByStudentSeq() throws IOException {


        GradeQueryService service = new DefaultGradeQueryService();

        service.getScoreByStudentSeq(13);

        Assertions.assertSame(service,true);


    }
}