package com.nhnacademy.gw1.parking.domain;

public class UserImpl implements User{
    String userId;
    int money;
    Car car;


    public UserImpl(String userId, int money, Car car){
        this.userId = userId;
        this.money = money;
        this.car = car;
    }

    @Override
    public String getId() {
        return this.userId;
    }

    @Override
    public int getMoney() {
        return this.money;
    }

    public String getCarNumber(){
        return car.getCarNumber();
    }

    public int ParkingFeePayment(int parkingFee){
        return this.money - parkingFee;
    }
}
