package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.AOP.TestAnnotation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;


@Component
public class CsvScores implements Scores {


    @Autowired
    private static CsvScores instance = new CsvScores();



    /**
     * 1. findAll()
     * 해당 학생 객체를 List로 넣어준다.
     * */

    static Map<Integer, Integer> map;

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



    @TestAnnotation
    // TODO 5 : score.csv 파일에서 데이터를 읽어 멤버 변수에 추가하는 로직을 구현하세요.
    @Override
    public void load() throws IOException {

        map = new HashMap<>();
        try (InputStream inputStream = new FileSystemResource("C:\\Users\\yeomyalooo\\Documents\\GitHub\\nhnjava\\IDE\\springframework-core-project\\springframework-project1\\src\\main\\resources\\data\\score.csv").getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        ) {
            String line;
            while((line = reader.readLine()) != null) {
                String[] word = line.split(",");

                map.put(Integer.parseInt(word[0]),Integer.parseInt(word[1]));

            }
        }
    }


    @TestAnnotation

    @Override
    public List<Score> findAll() throws IOException {
        //load data - list / ... etc
        List<Score> scoreAList = new ArrayList<>();

        Scores instance = CsvScores.getInstance();

        instance.load();
        
/*        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            Integer intKey = entry.getKey();
            Integer intValue = entry.getValue();

            System.out.println(intKey+":"+intValue);
        }*/

        map.forEach((intKey, intValue) -> {
            scoreAList.add(new Score(intKey, intValue));
        });

        System.out.println(scoreAList);

        return scoreAList;
    }
}
