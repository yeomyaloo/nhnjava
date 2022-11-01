package com.nhnacademy.edu.hwiju.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


@DisplayName("계산기 테스트")
class CalculatorTest {
    private Calculator calculator = new Calculator();

    @Test
    @DisplayName("+ 테스트")
    void add() {
        int result = calculator.add(1,1);
        assertEquals(2, result);
    }
}