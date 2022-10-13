package com.nhnacademy.edu.springframework.greeting.config;


import com.nhnacademy.edu.springframework.greeting.Greeter;
import com.nhnacademy.edu.springframework.greeting.service.EnglishGreeter;
import com.nhnacademy.edu.springframework.greeting.service.KoreanGreeter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
//@ImportResource("classpath:/beans.xml")//meta data를 기술한 xml 파일을 불러들이는 애노테이션
public class ApplicationConfig {

//1:1로 bean 설정
/*
    @Bean(name = "koreanGreeter")
    public Greeter koreanGreeter(){
        return new KoreanGreeter();
    }

    @Bean(name = "englishGreeter")
    public Greeter englishGreeter(){
        return new EnglishGreeter();
    }

*/

}
