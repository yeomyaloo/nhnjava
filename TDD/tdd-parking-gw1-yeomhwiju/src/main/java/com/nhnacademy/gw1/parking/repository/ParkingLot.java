package com.nhnacademy.gw1.parking.repository;

import com.nhnacademy.gw1.parking.domain.Car;

import java.time.LocalDateTime;
import java.util.List;

public interface ParkingLot {

    public void enter();

    public Car exit(String exitCarNumber);

    public List<Car> getList();

    public Car parkingALotGetCar();

    public LocalDateTime getStartTime();

    public LocalDateTime getExitTime();


}
