package com.nhnacademy.edu.hwiju.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionTest {

    private final Calculator calculator = new Calculator();
    private final Person person = new Person("yaloo", "yeom");

    @Test
    void standardAssertions(){
        assertEquals(2, calculator.add(1,1));
        assertEquals(4, calculator.multiply(2,2));
        assertTrue('a' < 'b', ()-> "Assertion messsage는 지연 로딩과 비슷하게 동작한다. " +
                "불필요하게 메시지를 만드는 일을 피하기 위해서.");
    }

    @Test
    void groupedAssertions(){
        assertAll("person", ()-> assertEquals("yeom" ,person.getLastName()),
                ()-> assertEquals("yaloo", person.getFirstName()));
    }


    @Test
    void exceptionTesting() {
        // TODO: 테스트가 성공할 수 있게 구현해주세요.
        Exception exception = assertThrows(ArithmeticException.class, () ->
                calculator.divide(1, 0));
        assertEquals("/ by zero", exception.getMessage());
    }



    }





