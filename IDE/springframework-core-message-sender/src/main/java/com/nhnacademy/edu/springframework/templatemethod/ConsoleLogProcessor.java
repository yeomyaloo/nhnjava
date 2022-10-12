package com.nhnacademy.edu.springframework.templatemethod;

/**
 * 구현은 여기서 진행이 되었지만 실질적으로 흐름은 AbstractProcessor에 의해 제어가 된다.
 * */
public class ConsoleLogProcessor extends AbstractProcessor{


    @Override
    protected void preProcess() {
        System.out.println("preProcess");
    }

    @Override
    protected void mainProcess() {
        System.out.println("mainProcess");
    }

    @Override
    protected void postProcess() {
        System.out.println("postProcess");
    }


}
