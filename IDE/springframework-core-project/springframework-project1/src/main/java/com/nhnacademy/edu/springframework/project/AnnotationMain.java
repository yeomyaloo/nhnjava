package com.nhnacademy.edu.springframework.project;

import com.nhnacademy.edu.springframework.project.config.RepositoryConfig;
import com.nhnacademy.edu.springframework.project.config.ServiceConfig;
import com.nhnacademy.edu.springframework.project.repository.CsvScores;
import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Scores;
import com.nhnacademy.edu.springframework.project.repository.StudentService;
import com.nhnacademy.edu.springframework.project.repository.Students;
import com.nhnacademy.edu.springframework.project.service.CsvDataLoadService;
import com.nhnacademy.edu.springframework.project.service.DataLoadService;
import com.nhnacademy.edu.springframework.project.service.DefaultGradeQueryService;
import com.nhnacademy.edu.springframework.project.service.DefaultStudentService;
import com.nhnacademy.edu.springframework.project.service.GradeQueryService;
import java.io.IOException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationMain {


    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            ServiceConfig.class, RepositoryConfig.class);


        Students students = context.getBean(CsvStudents.class);
        Scores scores = context.getBean(CsvScores.class);

        students.findAll();
        scores.findAll();


        /**
         * service 확인
         * */
        DataLoadService dataLoadService = context.getBean(CsvDataLoadService.class);
        dataLoadService.loadAndMerge();

        GradeQueryService gradeQueryService = context.getBean(DefaultGradeQueryService.class);
        gradeQueryService.getScoreByStudentName("A");
        gradeQueryService.getScoreByStudentSeq(13);

        StudentService studentService = context.getBean(DefaultStudentService.class);
        studentService.getStudentsOrderByScore();
        studentService.getStudentsOrderByScore();




    }






}
