package com.nhnacademy.gw1.parking.repository;

import com.nhnacademy.gw1.parking.domain.Car;
import com.nhnacademy.gw1.parking.domain.Entrance;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParkingLotTest {


    @DisplayName("해당 parkingspace에 들어온 객체들이 enter메소드를 통해서 잘 저장되는지 확인하는 테스트")
    @Test
    void test(){

        String carNum = "1234";
        Car car = new Car(carNum);


        //FIXME: 해당 부분이 겹치는 코드가 많으니 리팩토링 고민해볼 것
        Entrance entrance = new Entrance();
        entrance.scan(car);
        ㅖ

    }


}