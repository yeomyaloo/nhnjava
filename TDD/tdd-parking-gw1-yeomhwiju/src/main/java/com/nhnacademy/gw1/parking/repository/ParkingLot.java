package com.nhnacademy.gw1.parking.repository;

import com.nhnacademy.gw1.parking.domain.Car;

import java.util.List;

public interface ParkingLot {

    public void enter();

    public Car exit();

    public List<Car> getList();
}
