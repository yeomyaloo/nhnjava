package com.nhnacademy.gw1.parking.domain;

import com.nhnacademy.gw1.parking.exception.AlreadyExistsUserIdException;
import com.nhnacademy.gw1.parking.repository.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParkingSystemTest {
    @DisplayName("해당 User와 Car객체를 구현체로 관리하는 테스트")
    @Test
    void user_parkingsystem(){

        String carNum = "1234";
        Car car = new Car(carNum);
        Entrance entrance = new Entrance();
        ParkingSpace parkingSpace = new ParkingSpace(entrance.scan(car), Code.A_CODE);
        ParkingLot parkingLot = new ParkingLotArrayListImp(parkingSpace.getCar(),Code.A_CODE);


        String userName = "hi1";
        int money = 10000;

        ParkingSystem parkingSystem = new ParkingSystemImpl(car,parkingLot);

        parkingSystem.addUserParkingInfo(userName,money);

        assertThat(parkingSystem.getUserList().size()).isEqualTo(1);
        assertThatThrownBy(()-> parkingSystem.addUserParkingInfo(userName,money))
                .isInstanceOf(AlreadyExistsUserIdException.class)
                .hasMessageContaining("already user id");
        assertThat(parkingSystem.getUserList().get(0).getId()).isEqualTo("hi1");
        assertThat(parkingSystem.getUserList().get(0).getCarNumber()).isEqualTo("1234");
    }








}