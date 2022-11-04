package com.nhnacademy.gw1.parking.repository;

public enum Code {

    A_CODE("A"),
    B_CODE("B"),
    C_CODE("C");

    private final String parkingSpace_code;

    Code(String parkingSpace_code) {
        this.parkingSpace_code = parkingSpace_code;
    }

    public String getParkingSpace_code() {
        return parkingSpace_code;
    }
}
