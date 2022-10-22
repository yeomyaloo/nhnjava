package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.AOP.TestAnnotation;
import com.nhnacademy.edu.springframework.project.service.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;


@Component
public class CsvStudents implements Students {

    @Autowired
    private static CsvStudents instance = new CsvStudents();


    Map<Integer, String> map;


    private CsvStudents(){

    }

    /** TODO 3 :
     * Java Singleton 패턴으로 getInstance() 를 구현하세요.
     **/
    public static Students getInstance() {
        if (instance == null) {
            return new CsvStudents();
        }
        return instance;
    }

    // TODO 7 : student.csv 파일에서 데이터를 읽어 클래스 멤버 변수에 추가하는 로직을 구현하세요.
    // 데이터를 적재하고 읽기 위해서, 적절한 자료구조를 사용하세요.
    @Override
    @TestAnnotation
    public void load() throws IOException {


        map = new HashMap<>();
        try (InputStream inputStream = new FileSystemResource("C:\\Users\\yeomyalooo\\Documents\\GitHub\\nhnjava\\IDE\\springframework-core-project\\springframework-project1\\src\\main\\resources\\data\\student.csv").getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        ) {
            String line;
            while((line = reader.readLine()) != null) {
                String[] word = line.split(",");

                map.put(Integer.parseInt(word[0]),word[1]);

            }
        }
        System.out.println(map);
    }




    /**
     * 1. load()로 해당 csv 파일을 읽어서 map형식으로 저장
     * 2. load()를 사용해서 map 형식으로 저장된 자료구조를 사용해서 해당 자료를 모두 find all
     * [ 문제점 ]
     *
     * 해당 student.csv는 어떻게 ?
     * 1 , A (학생번호? 점수?)
     *
     * */

    @Override
    @TestAnnotation
    public Collection<Student> findAll() throws IOException {

        List<Student> studentList = new ArrayList<>();

        instance.load();

        map.forEach((key, value)->{
            studentList.add(new Student(key,value));
        });


        return studentList;
    }

    /**
     * TODO 8 : students 데이터에 score 정보를 추가하세요.
     * @param scores
     */
    @Override
    @TestAnnotation
    public void merge(Collection<Score> scores) throws IOException {
        Students students = CsvStudents.getInstance();

        List<Object> mergedList = Stream.of(students.findAll(),scores)
                            .flatMap(Collection::stream)
                            .collect(Collectors.toList());


    }

}
