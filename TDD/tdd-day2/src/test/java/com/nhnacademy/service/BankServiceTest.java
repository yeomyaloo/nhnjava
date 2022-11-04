package com.nhnacademy.service;

import com.nhnacademy.currency.Currency;
import com.nhnacademy.domain.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class BankServiceTest {

    BankService bankService;
    Money money;

    @BeforeEach
    void setUp() {
        bankService = new BankService();
    }

    @DisplayName("천 원을 1달러로")
    @Test
    void convert_1000won_into_one_dollars_test() {
        double amount = 1000;
        Currency nationalCode = Currency.KRW;

        Money krwMoney = new Money(amount, nationalCode);

        assertThat(bankService.exchange(krwMoney)).usingRecursiveComparison().isEqualTo(new Money(1, Currency.USD));
    }

    @DisplayName("1달러를 천 원으로")
    @Test
    void convert_one_dollars_into_1000won_test() {
        double amount = 1;
        Currency nationalCode = Currency.USD;

        Money usdMoney = new Money(amount, nationalCode);

        assertThat(bankService.exchange(usdMoney)).usingRecursiveComparison().isEqualTo(new Money(1000, Currency.KRW));
    }

    @DisplayName("5.25$ -> 5,250원")
    @Test
    void convert_won_into_dollars_test() {
        double amount = 5.2506767;
        Currency nationalCode = Currency.USD;

        Money usdMoney = new Money(amount, nationalCode);

        assertThat(bankService.exchange(usdMoney)).usingRecursiveComparison().isEqualTo(new Money(5250, Currency.KRW));

        assertThat(String.valueOf(usdMoney.getMoney())).isEqualTo("5.25");

    }

    @DisplayName("달러 -> 원화: 5원 이상 -> 10원으로 반올림")
    @Test
    void convert_dollars_into_won_rounded_over_five_won() {
        double amount = 0.005;
        Currency nationalCode = Currency.USD;

        Money usdMoney = new Money(amount, nationalCode);
        Money krwMoney = bankService.exchange(usdMoney);


        assertThat(bankService.roundMoney(krwMoney.getMoney())).isEqualTo(new Money(10, Currency.KRW).getMoney());

    }

}