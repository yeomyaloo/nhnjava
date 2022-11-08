package com.nhnacademy.gw1.parking.repository;

import com.nhnacademy.gw1.parking.domain.User;
import com.nhnacademy.gw1.parking.repository.ParkingLot;

import java.util.List;
import java.util.Map;

public interface ParkingSystem {

    public void addUserParkingInfo(String userName, int userMoney);
    public List<User> getUserList();
}
