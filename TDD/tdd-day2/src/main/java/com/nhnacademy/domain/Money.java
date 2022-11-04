package com.nhnacademy.domain;

import com.nhnacademy.currency.Currency;
import com.nhnacademy.exception.InvalidCalculateUnderZero;
import com.nhnacademy.exception.InvalidLaguageException;
import com.nhnacademy.exception.IsNotNegativeNumberException;

public class Money {

    private final double money;
    private final Currency nationalCode;

    public Money(double money, Currency nationalCode) {
        if(money < 0){
           throw new IsNotNegativeNumberException();
        }
        this.money = Math.round(money*100)/100.0;
        this.nationalCode = nationalCode;
    }


    public double getMoney() {
        return this.money;
    }

    public Money add(Money newMoney) {
        return new Money(this.money+newMoney.getMoney(), this.nationalCode);
    }

    public Currency getNationalCode() {
        return this.nationalCode;
    }

    public Money sub(Money money) {
        if (this.money < money.getMoney()) {
            throw new InvalidCalculateUnderZero();
        }
        return new Money(this.money - money.getMoney(), this.nationalCode);
    }
}
