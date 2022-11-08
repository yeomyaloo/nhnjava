package com.nhnacademy.gw1.parking.service;

import com.nhnacademy.gw1.parking.domain.Car;

public class ExitService {

    PaymentService paymentService;
    Car car;


    public ExitService(PaymentService paymentService, Car car) {
        this.paymentService = paymentService;
        this.car = car;
    }




}
