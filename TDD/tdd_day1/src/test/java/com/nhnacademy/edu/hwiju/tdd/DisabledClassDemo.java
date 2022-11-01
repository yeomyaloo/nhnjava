package com.nhnacademy.edu.hwiju.tdd;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled("Disabled until bug #99 has been fixed")
public class DisabledClassDemo {

    @Test
    void testWillBeSkipped() {

        System.out.println("testWillVeSkipped");
    }


    class DisabledTestsDemo {

        @Disabled("Disabled until bug #42 has been resolved")
        @Test
        void testWillBeSkipped() {


        }

        @Test
        void testWillBeExecuted() {
        }
}