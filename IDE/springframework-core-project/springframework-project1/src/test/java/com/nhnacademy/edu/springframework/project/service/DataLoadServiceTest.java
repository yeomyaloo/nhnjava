package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.CsvScores;
import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Score;
import com.nhnacademy.edu.springframework.project.repository.Scores;
import com.nhnacademy.edu.springframework.project.repository.Students;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataLoadServiceTest {

    @Test
    void loadAndMerge() throws IOException {

        DataLoadService dataLoadService = new CsvDataLoadService();

        Scores score = CsvScores.getInstance();
        Students students = CsvStudents.getInstance();

        score.load();
        students.load();


        dataLoadService.loadAndMerge();

    }
}