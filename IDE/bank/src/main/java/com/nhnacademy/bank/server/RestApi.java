package com.nhnacademy.bank.server;



import com.nhnacademy.bank.domain.Account;
import com.nhnacademy.bank.domain.Money;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

public class RestApi {
    Account account = new Account();
    public boolean postAmount(Action action, Long accountNumber, BigDecimal amount){
        System.out.println("action : " + action + " accountNumber :  "+ accountNumber + " amount : " + amount);

        if (Action.DEPOSIT == action){
            return account.deposit(new Money(amount, Currency.getInstance(Locale.US)));

        } else if (Action.WITHDRAW == action) {
            return account.deposit(new Money(amount, Currency.getInstance(Locale.US)));
        }

        return true;
    }
}
