package com.nhnacademy.currency;


public enum Currency {
    KRW ("KRW", 1),
    USD ("USD", 1000),

    EUR("EUR", 1400);



    private final String nationalCode;
    private final int exchangeRate;

    Currency(String nationalCode, int exchangeRate) {
        this.nationalCode = nationalCode;
        this.exchangeRate = exchangeRate;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public int getExchangeRate() {
        return exchangeRate;
    }
}
