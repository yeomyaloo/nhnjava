package com.nhnacademy.edu.springframework.project.repository;

import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentsTest {


    @Test
    void load() throws IOException {


        Students students1 = CsvStudents.getInstance();
        Students students2 = CsvStudents.getInstance();


        students1.load();
        students2.load();


        Assertions.assertEquals(students2, students1);

    }

    @Test
    void findAll() throws IOException {

        Students students1 = CsvStudents.getInstance();
        Students students2 = CsvStudents.getInstance();


        students1.findAll();
        students2.findAll();

        Assertions.assertEquals(students2.toString(), students1.toString());

    }

    @Test
    void merge() throws IOException {

        Students students = CsvStudents.getInstance();
        Scores scores = CsvScores.getInstance();

        Students students1 = CsvStudents.getInstance();
        Scores scores1 = CsvScores.getInstance();






    }
}