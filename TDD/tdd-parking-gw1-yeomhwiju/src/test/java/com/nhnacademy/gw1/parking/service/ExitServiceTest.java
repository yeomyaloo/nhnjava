package com.nhnacademy.gw1.parking.service;

import com.nhnacademy.gw1.parking.domain.Car;
import com.nhnacademy.gw1.parking.domain.Entrance;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ExitServiceTest {

    @DisplayName("차가 들어오면 번호판을 인식한다.")
    @Test
    void test1(){

        String carNumber = "1234";
        Car car = new Car(carNumber);

        Entrance entrance = new Entrance();
        assertThat(entrance.scan(car).getCarNumber()).isEqualTo("1234");

    }



}