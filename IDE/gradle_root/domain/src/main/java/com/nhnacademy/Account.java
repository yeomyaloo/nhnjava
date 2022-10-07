package com.nhnacademy;

import java.util.Currency;
import java.util.Locale;


/**
 * format -> windows ctrl + alt + L settings -> Tools -> action on save -> 1, 2번
 */
public class Account {

    public boolean deposit(Money money) {
        System.out.println("money : " + money);
        new Money(money.getAmount(), Currency.getInstance(Locale.US));
        return true;

    }

    public boolean withdraw(Money money) {
        System.out.println("money : " + money);
        new Money(money.getAmount(), Currency.getInstance(Locale.US));
        return true;
    }
}
