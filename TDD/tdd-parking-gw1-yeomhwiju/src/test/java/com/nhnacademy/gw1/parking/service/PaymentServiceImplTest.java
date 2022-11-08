package com.nhnacademy.gw1.parking.service;

import com.nhnacademy.gw1.parking.domain.Car;
import com.nhnacademy.gw1.parking.domain.Entrance;
import com.nhnacademy.gw1.parking.domain.ParkingSpace;
import com.nhnacademy.gw1.parking.repository.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceImplTest {

    @DisplayName("해당 입차 시간과 출차 시간에 제대로 계산이 되는지 여부 확인")
    @Test
    void onOffCheck(){


        String carNum = "1234";
        Car car = new Car(carNum);
        Entrance entrance = new Entrance();
        ParkingSpace parkingSpace = new ParkingSpace(entrance.scan(car), Code.A_CODE);
        ParkingLot parkingLot = new ParkingLotArrayListImp(parkingSpace.getCar(),Code.A_CODE);


        ParkingSystem parkingSystem = new ParkingSystemImpl(car,parkingLot);
        PaymentService paymentService = new PaymentServiceImpl(parkingSystem);

        LocalDateTime startTime = LocalDateTime.of(2022, 1, 1, 0, 0, 0);
        LocalDateTime endTime = LocalDateTime.of(2022, 1, 2, 0, 0, 0);

        assertThat(paymentService.pay(startTime,endTime)).isEqualTo(10000);

    }

}