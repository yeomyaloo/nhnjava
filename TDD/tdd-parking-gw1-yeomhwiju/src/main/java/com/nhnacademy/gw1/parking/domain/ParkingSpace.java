package com.nhnacademy.gw1.parking.domain;

import com.nhnacademy.gw1.parking.domain.Car;
import com.nhnacademy.gw1.parking.repository.Code;

public class ParkingSpace{

    //특정 주차구역
    //String code;
    Code code;
    Car car;

    public ParkingSpace(Car entranceCar,Code code) {
        this.car = entranceCar;
        this.code = code;
    }

    public String getCode() {
        return code.getParkingSpace_code();
    }

    public Car getCar() {
        return car;
    }
}
