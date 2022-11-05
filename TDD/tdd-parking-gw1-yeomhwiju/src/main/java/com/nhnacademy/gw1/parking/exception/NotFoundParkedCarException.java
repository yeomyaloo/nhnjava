package com.nhnacademy.gw1.parking.exception;

public class NotFoundParkedCarException extends RuntimeException {

    public NotFoundParkedCarException() {
        super("The parked car could not be found.");
    }
}
