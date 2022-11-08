package com.nhnacademy.gw1.parking.repository;

import com.nhnacademy.gw1.parking.domain.Car;
import com.nhnacademy.gw1.parking.exception.AlreadyExistsCarNumberException;
import com.nhnacademy.gw1.parking.exception.NotFoundParkedCarException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParkingLotArrayListImp implements ParkingLot{


    //FIXME : 해당 출입, 출차 시 시간을 받고 이에 맞춰서 계산을 진행해야 한다.

    Car car;

    Code code;

    List<Car> list = new ArrayList<>();

    LocalDateTime enterTime;

    LocalDateTime exitTime;

    public ParkingLotArrayListImp(Car car, Code code) {
        this.car = car;
        this.code = code;
    }


    @Override
    public void enter() {
        isNot_exist_CarCheck();
        list.add(this.car);
        enterTime = LocalDateTime.now();
    }

    private boolean isNot_exist_CarCheck() {
        for (Car parkingCar : list) {
            if(parkingCar.getCarNumber().equals(car.getCarNumber())){
                throw new AlreadyExistsCarNumberException();
            }
        }
        return true;
    }


    @Override
    public Car exit(String exitCarNumber) {
        for (Car parkingCar : list) {
            if(parkingCar.getCarNumber().equals(exitCarNumber)){
                list.remove(parkingCar);
                exitTime = LocalDateTime.now();
                return parkingCar;
            }
        }
        throw new NotFoundParkedCarException();
    }

    public List<Car> getList() {
        return list;
    }

    public Car parkingALotGetCar(){
        return this.car;
    }

    @Override
    public LocalDateTime getStartTime() {
        return enterTime;
    }

    @Override
    public LocalDateTime getExitTime() {
        return exitTime;
    }


}
