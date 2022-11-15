package com.nhnacademy.springmvc.repository;

import com.nhnacademy.springmvc.domain.Student;
import com.nhnacademy.springmvc.exception.NotFoundStudentException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class StudentRepositoryImpl implements StudentRepository {
    Map<Long, Student> map = new HashMap<>();
    static long idCnt = 1;
    Student student;

    @Override
    public boolean exists(long id) {
        return false;
    }

    @Override
    public Student register(String name, String email, int score, String comment) {
        student = new Student(idCnt, name, email, score, comment);
        map.put(idCnt,student);
        ++idCnt;
        return student;
    }

    @Override
    public Student getStudent(long id) {
        //FIXME: 예외처리
        if(map.containsKey(id)){

            throw new NotFoundStudentException();
        }
        return map.get(id);

    }

    @Override
    public Student modify(long id, String name, String email, int score, String comment) {
        Student newStudent = new Student(id, name, email, score, comment);

        map.put(newStudent.getId(), newStudent);

        return newStudent;
    }




}
