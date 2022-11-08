package com.nhnacademy.gw1.parking.service;

import com.nhnacademy.gw1.parking.domain.Car;

import java.time.LocalDateTime;
import java.util.Date;

public interface PaymentService {


    public int pay(LocalDateTime startTime, LocalDateTime exitTime);

}
