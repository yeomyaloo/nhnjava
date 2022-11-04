package com.nhnacademy.service;

import com.nhnacademy.currency.Currency;
import com.nhnacademy.domain.Money;

import java.util.function.IntPredicate;

public class BankService {
    Money money;


    public Money exchange(Money currencyMoney) {
        if (currencyMoney.getNationalCode().equals(Currency.USD)) {
            return new Money(currencyMoney.getMoney() * Currency.USD.getExchangeRate(), Currency.KRW);
        }
        return new Money(currencyMoney.getMoney()/Currency.USD.getExchangeRate(), Currency.USD);
    }



    public double roundMoney(double money) {
        if(money < 0.5){
            return money;
        }
        return Math.round(money / 10) * 10;
    }
}
