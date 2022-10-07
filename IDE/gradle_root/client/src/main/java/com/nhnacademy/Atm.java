package com.nhnacademy;

import java.math.BigDecimal;

public class Atm {

    public boolean deposit(BigDecimal amount, Long accountNumber){
        System.out.println("amount : " + amount + " accountNumber : " + accountNumber);
        return new RestApi().postAmount(Action.DEPOSIT, accountNumber, amount);
    }
    public boolean withDraw(BigDecimal amount, Long accountNumber){
        System.out.println("amount : " + amount + " accountNumber : " + accountNumber);
        boolean rt = new RestApi().postAmount(Action.WITHDRAW, accountNumber, amount);
        return rt;
    }
}
