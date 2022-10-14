package com.nhnacademy.edu.springframework.project.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.core.io.FileSystemResource;

public class CsvScores implements Scores {

    static CsvScores instance;


    Map<String , String> map = new HashMap<>();

    //생성자를 private로 만들어 접근을 막음
    private CsvScores(){}

    /** TODO 2 :
     * Java Singleton 패턴으로 getInstance() 를 구현하세요.
     **/
    public static Scores getInstance() {
        if (instance == null){
            instance = new CsvScores();
        }
        return instance;
    }



    // TODO 5 : score.csv 파일에서 데이터를 읽어 멤버 변수에 추가하는 로직을 구현하세요.
    @Override
    public void load() throws IOException {

        try (InputStream inputStream = new FileSystemResource("C:\\Users\\yeomyalooo\\Documents\\GitHub\\nhnjava\\IDE\\springframework-core-project\\springframework-project1\\src\\main\\resources\\data\\score.csv").getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        ) {
            String line;
            while((line = reader.readLine()) != null) {


                String[] word = line.split(",");
                map.put(word[0],word[1]);

            }
        }
    }

    @Override
    public List<Score> findAll() {



        return null;
    }
}
