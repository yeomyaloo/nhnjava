package com.nhnacademy.edu.springframework.templatemethod;

public class TemplateMethodMain {
    public static void main(String[] args) {
        //해당 구현체를 사용
        AbstractProcessor abstractProcessor = new ConsoleLogProcessor();
        abstractProcessor.process();
    }
}
