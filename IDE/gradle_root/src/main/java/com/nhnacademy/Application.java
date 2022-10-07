package com.nhnacademy;


import java.math.BigDecimal;


/**
 * Application class, entry point.
 * */
public class Application {
    private static final Long ACCOUNT_NUMBER = 123L;


    /**
     * entry point main method.
     *
     * @param args system variable.
     * */
    //Entry point => main class 진입점
    public static void main(String[] args) {

        System.out.println("Application.main() callstack start");
        Atm atm = new Atm();
        boolean rt = atm.deposit(BigDecimal.valueOf(100.1), ACCOUNT_NUMBER);
        System.out.println("Application.main() callstack end"+rt);
    }

    
}
