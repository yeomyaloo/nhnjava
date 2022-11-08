package com.nhnacademy.gw1.parking.service;

import com.nhnacademy.gw1.parking.domain.Car;
import com.nhnacademy.gw1.parking.domain.ParkingSpace;
import com.nhnacademy.gw1.parking.repository.ParkingSystem;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class PaymentServiceImpl implements PaymentService{

    ParkingSystem parkingSystem;

    public PaymentServiceImpl(ParkingSystem parkingSystem) {
        this.parkingSystem = parkingSystem;
    }

    private final static int MINIMUM_FEE =  1000;
    private final static int ADDITIONAL_TEN_MINUTES_FEE = 500;
    private final static int ADDITIONAL_ONE_DAT_FEE = 10000;

    @Override
    public int pay(LocalDateTime startTime, LocalDateTime exitTime) {

        long parkingDays = ChronoUnit.DAYS.between(startTime, exitTime);
        long parkingMinute = ChronoUnit.MINUTES.between(startTime, exitTime);
        long parkingHours = ChronoUnit.HOURS.between(startTime, exitTime);
        long totalParkingFee = 0;


        if(parkingMinute < 30) {
            totalParkingFee += MINIMUM_FEE;
        }

        if(parkingDays > 0){
            totalParkingFee += parkingDays * ADDITIONAL_ONE_DAT_FEE;
        }

        if(parkingMinute > 30 && parkingHours < 6){
            totalParkingFee += (parkingMinute-30)*ADDITIONAL_TEN_MINUTES_FEE;
        }

        return (int) totalParkingFee;
    }

}
