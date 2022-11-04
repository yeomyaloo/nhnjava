package com.nhnacademy.gw1.parking.repository;

import com.nhnacademy.gw1.parking.domain.Car;
import com.nhnacademy.gw1.parking.domain.ParkingSpace;
import com.nhnacademy.gw1.parking.domain.Entrance;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ParkingSpaceTest {

    @DisplayName("차를 특정 주차구역에 주차합니다.")
    @Test
    void test1(){

        String carNum = "1234";
        String parkingCode = "A";

        Car car = new Car(carNum);
        Entrance entrance = new Entrance();
        ParkingSpace parkingSpace = new ParkingSpace(entrance.scan(car), Code.A_CODE);


        assertThat(parkingSpace.getCode()).isEqualTo("A");
        assertThat(parkingSpace.getCar().getCarNumber()).isEqualTo("1234");

    }

    @DisplayName("enum class를 사용한 주차 구역 설정 테스트")
    @Test
    void test2(){
        String carNum = "1234";
        String code = "A";

        Car car = new Car(carNum);
        Entrance entrance = new Entrance();

        ParkingSpace parkingSpace = new ParkingSpace(entrance.scan(car), Code.A_CODE);



        assertThat(parkingSpace.getCar().getCarNumber()).isEqualTo(new ParkingSpace(entrance.scan(car),Code.A_CODE).getCar().getCarNumber());
        assertThat(parkingSpace.getCode()).isEqualTo(new ParkingSpace(entrance.scan(car),Code.A_CODE).getCode());

    }



}