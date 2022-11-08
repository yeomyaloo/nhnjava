package com.nhnacademy.gw1.parking.repository;

import com.nhnacademy.gw1.parking.domain.Car;
import com.nhnacademy.gw1.parking.domain.User;
import com.nhnacademy.gw1.parking.domain.UserImpl;
import com.nhnacademy.gw1.parking.exception.AlreadyExistsUserIdException;
import com.nhnacademy.gw1.parking.exception.NoSuchExitCarUserException;

import java.util.ArrayList;
import java.util.List;

public class ParkingSystemImpl implements ParkingSystem{

    ParkingLot parkingLot;
    Car car;
    List<User> userParkingLotList = new ArrayList<>();

    public ParkingSystemImpl(Car car,ParkingLot parkingLot) {
        this.car = car;
        this.parkingLot = parkingLot;
    }

    @Override
    public void addUserParkingInfo(String userId, int userMoney) {

        for (User user : userParkingLotList) {
            if (user.getId().equals(userId)){
                throw new AlreadyExistsUserIdException();
            }
        }
        userParkingLotList.add(new UserImpl(userId,userMoney,car));
    }

    public User getUser(String exitUserId){
        for (User user : userParkingLotList) {
            if(user.getId().equals(exitUserId)){
                return user;
            }
        }
        throw new NoSuchExitCarUserException();
    }

    @Override
    public List<User> getUserList() {
        return userParkingLotList;
    }
}
