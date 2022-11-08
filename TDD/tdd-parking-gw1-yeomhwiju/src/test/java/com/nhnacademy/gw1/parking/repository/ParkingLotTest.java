package com.nhnacademy.gw1.parking.repository;

import com.nhnacademy.gw1.parking.domain.Car;
import com.nhnacademy.gw1.parking.domain.Entrance;
import com.nhnacademy.gw1.parking.domain.ParkingSpace;
import com.nhnacademy.gw1.parking.exception.AlreadyExistsCarNumberException;
import com.nhnacademy.gw1.parking.exception.NotFoundParkedCarException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParkingLotTest {



    @DisplayName("해당 parkingspace에 들어온 객체들이 enter() 메소드를 통해서 잘 저장되는지 확인하는 테스트")
    @Test
    void enterance_confirmation(){

        String carNum = "1234";
        Car car = new Car(carNum);

        //FIXME: 해당 부분이 겹치는 코드가 많으니 리팩토링 고민해볼 것
        Entrance entrance = new Entrance();
        ParkingSpace parkingSpace = new ParkingSpace(entrance.scan(car),Code.A_CODE);

        ParkingLot parkingLot = new ParkingLotArrayListImp(parkingSpace.getCar(),Code.A_CODE);

        parkingLot.enter();

        // FIXME: parkinglot에 구역 없이 차 번호만 들어가도 될까?
        assertThat(parkingLot.getList().get(0).getCarNumber()).isEqualTo("1234");
        assertThatThrownBy(()-> parkingLot.enter())
                .isInstanceOf(AlreadyExistsCarNumberException.class)
                .hasMessageContaining("car number that already exists");

    }


    @DisplayName("이미 존재하는 차 번호라면 저장 리스트에 들어가지 않도록 한다.")
    @Test
    void duplicate_carNumber(){

        String carNum = "1234";
        Car car = new Car(carNum);

        //FIXME: 해당 부분이 겹치는 코드가 많으니 리팩토링 고민해볼 것
        Entrance entrance = new Entrance();
        ParkingSpace parkingSpace = new ParkingSpace(entrance.scan(car),Code.A_CODE);

        ParkingLot parkingLot = new ParkingLotArrayListImp(parkingSpace.getCar(),Code.A_CODE);

        parkingLot.enter();

        // FIXME: parkinglot에 구역 없이 차 번호만 들어가도 될까? 차번호는 겹치면 안 된다.
        assertThat(parkingLot.getList().get(0).getCarNumber()).isEqualTo("1234");
        assertThatThrownBy(()-> parkingLot.enter())
                .isInstanceOf(AlreadyExistsCarNumberException.class)
                .hasMessageContaining("car number that already exists");

    }

    @DisplayName("exit()로 들어가 있는 차 번호가 제대로 삭제되는지 확인해야 한다.")
    @Test
    void final_removal(){

        String carNum = "1234";
        Car car = new Car(carNum);

        //FIXME: 해당 부분이 겹치는 코드가 많으니 리팩토링 고민해볼 것
        Entrance entrance = new Entrance();
        ParkingSpace parkingSpace = new ParkingSpace(entrance.scan(car),Code.A_CODE);

        ParkingLot parkingLot = new ParkingLotArrayListImp(parkingSpace.getCar(),Code.A_CODE);
        parkingLot.enter();
        parkingLot.exit("1234");
        assertThat(parkingLot.getList()).isEmpty();

    }

    @DisplayName("exit()로 들어가 출차하고자 하는 차 번호가 없다면 예외를 던지는 테스트")
    @Test
    void uncofirmed_car(){

        String carNum = "1234";
        Car car = new Car(carNum);

        //FIXME: 해당 부분이 겹치는 코드가 많으니 리팩토링 고민해볼 것
        Entrance entrance = new Entrance();
        ParkingSpace parkingSpace = new ParkingSpace(entrance.scan(car),Code.A_CODE);

        ParkingLot parkingLot = new ParkingLotArrayListImp(parkingSpace.getCar(),Code.A_CODE);

        assertThatThrownBy(()-> parkingLot.exit("1234"))
                .isInstanceOf(NotFoundParkedCarException.class)
                .hasMessageContaining("The parked car could not be found.");



    }






}