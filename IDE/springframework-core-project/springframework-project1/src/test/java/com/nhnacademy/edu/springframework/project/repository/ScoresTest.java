package com.nhnacademy.edu.springframework.project.repository;

import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoresTest {

    @Test
    void load() throws IOException {

        Scores scores1 = CsvScores.getInstance();
        Scores scores2 = CsvScores.getInstance();


        scores1.load();
        scores2.load();

        Assertions.assertEquals(scores2.toString(),scores1.toString());

    }

    @Test
    void findAll() throws IOException {

        Scores scores1 =CsvScores.getInstance();
        Scores scores2 = CsvScores.getInstance();

        scores1.findAll();
        scores2.findAll();

        Assertions.assertEquals(scores2.toString(),scores1.toString());


    }
}