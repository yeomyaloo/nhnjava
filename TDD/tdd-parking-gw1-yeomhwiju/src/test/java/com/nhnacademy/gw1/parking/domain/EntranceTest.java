package com.nhnacademy.gw1.parking.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

class EntranceTest {

    @DisplayName("차가 들어오면 번호판을 인식한다.")
    @Test
    void scanner_carNumber(){

        String carNumber = "1234";
        Car car = new Car(carNumber);

        Entrance entrance = new Entrance();
        assertThat(entrance.scan(car).getCarNumber()).isEqualTo("1234");


        Date today = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
        System.out.println(simpleDateFormat.format(today));
    }



}