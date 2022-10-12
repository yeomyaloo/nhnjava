package com.nhnacademy.edu.springframework.templatemethod;


/**
 *  프레임워크가 해당 코드를 제공했다고 가정해보자
 * */
public abstract class AbstractProcessor {

    public final void process() {

        preProcess();
        mainProcess();
        postProcess();
    }


    protected abstract void preProcess();
    protected abstract void mainProcess();
    protected abstract void postProcess();

}
