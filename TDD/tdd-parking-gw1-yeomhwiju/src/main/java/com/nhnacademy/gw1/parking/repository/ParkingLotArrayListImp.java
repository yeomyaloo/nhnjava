package com.nhnacademy.gw1.parking.repository;

import com.nhnacademy.gw1.parking.domain.Car;
import com.nhnacademy.gw1.parking.exception.AlreadyExistsCarNumberException;
import com.nhnacademy.gw1.parking.exception.NotFoundParkedCarException;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotArrayListImp implements ParkingLot{


    //FIXME : 해당 출입, 출차 시 시간을 받고 이에 맞춰서 계산을 진행해야 한다.

    Car car;

    List<Car> list = new ArrayList<>();


    public ParkingLotArrayListImp(Car car) {
        this.car = car;

    }


    @Override
    public void enter() {
        isNot_exist_CarCheck();
        list.add(this.car);
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
    public Car exit() {
        for (Car parkingCar : list) {
            if(parkingCar.getCarNumber().equals(car.getCarNumber())){
                list.remove(parkingCar);
                return parkingCar;
            }
        }

        throw new NotFoundParkedCarException();
    }

    public List<Car> getList() {
        return list;
    }
}
