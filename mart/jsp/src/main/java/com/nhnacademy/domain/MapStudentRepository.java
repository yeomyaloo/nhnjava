package com.nhnacademy.domain;

import java.util.HashMap;
import java.util.Map;

public class MapStudentRepository implements StudentRepository{


    //학번을 key로 student 객체를 저장
    private Map<String, Student> map = new HashMap<>();

    @Override
    public void addStudent(Student student) {
        String id = student.getId();
        map.put(id,student);
    }
    @Override
    public Student get(String id) {
        return map.get(id);
    }


}
