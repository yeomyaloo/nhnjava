package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.service.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.core.io.FileSystemResource;


public class CsvStudents implements Students {

    static CsvStudents instance;


    Map<Character, Character> map = new HashMap<Character, Character>();


    private CsvStudents(){}

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
    public void load() throws IOException {

        try (InputStream inputStream = new FileSystemResource("C:\\Users\\yeomyalooo\\Documents\\GitHub\\nhnjava\\IDE\\springframework-core-project\\springframework-project1\\src\\main\\resources\\data\\students.csv").getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        ) {
            String line;
            while((line = reader.readLine()) != null) {
                map.put(line.charAt(0), line.charAt(1));
            }
        }
    }

    @Override
    public Collection<Student> findAll() {
        return null;

    }

    /**
     * TODO 8 : students 데이터에 score 정보를 추가하세요.
     * @param scores
     */
    @Override
    public void merge(Collection<Score> scores) {



    }
}
