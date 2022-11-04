package com.nhnacademy.edu.hwiju.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assumptions.assumeTrue;



public class AssumptionTest {
    private final Calculator calculator  = new Calculator();

    @Test
    void testOnlyOnCiServer(){
        assumeTrue("DEV".equals(System.getenv("ENV")),
                () -> "Aborting test: not on developer workstation");
    }




}
