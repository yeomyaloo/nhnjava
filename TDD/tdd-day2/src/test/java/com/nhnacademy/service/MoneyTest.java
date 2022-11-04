package com.nhnacademy.service;

import com.nhnacademy.currency.Currency;
import com.nhnacademy.domain.Money;
import com.nhnacademy.exception.InvalidCalculateUnderZero;
import com.nhnacademy.exception.IsNotNegativeNumberException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;

class MoneyTest {

    @DisplayName("1000 + 1000 = result")
    @Test
    void add_money_to_money_inKRW() {
        int krwAmount = 1000;
        Currency nationalCode = Currency.KRW;
        Money money1 = new Money(krwAmount, nationalCode);
        Money money2 = new Money(krwAmount, nationalCode);

        Money money3 = new Money(money1.add(money2).getMoney(), nationalCode);
        assertThat(money3.getMoney()).isEqualTo(2000);
    }


    @DisplayName("1000원은 1000원이다.")
    @Test
    void money_vs_money_inKRW() {
        int krwAmount = 1000;
        Currency nationalCode = Currency.KRW;
        Money money1 = new Money(krwAmount, nationalCode);
        Money money2 = new Money(krwAmount, nationalCode);


        assertThat(money1.getMoney()).isEqualTo(money2.getMoney());
    }


    @DisplayName("돈은 음수일 수 없다.")
    @Test
    void when_isNegativeMoney_throwIsNotNegativeNumberException() {
        int krwAmount = -1000;
        Currency nationalCode = Currency.KRW;

        assertThatThrownBy(() -> new Money(krwAmount, nationalCode)).isInstanceOf(IsNotNegativeNumberException.class)
                .hasMessageContaining("negative number");
    }

    @DisplayName("5$ + 5$ = 10$")
    @Test
    void add_money_to_money_inUSD() {
        int usdAmount = 5;
        Currency nationalCode = Currency.USD;

        Money money1 = new Money(usdAmount, nationalCode);
        Money money2 = new Money(usdAmount, nationalCode);

        assertThat(money1.add(money2).getMoney()).isEqualTo(new Money(10, nationalCode).getMoney());
    }

    @DisplayName("5$ - 6$ = Error")
    @Test
    void add_result_isNegativeMoney_inUSD_throwInvalidCalculateUnderZero() {
        int amountA = 5;
        int amountB = 6;
        Currency nationalCode = Currency.USD;


        Money money1 = new Money(amountA, nationalCode);
        Money money2 = new Money(amountB, nationalCode);

        assertThatThrownBy(() -> money1.sub(money2)).isInstanceOf(InvalidCalculateUnderZero.class)
                .hasMessageContaining("invalid calculate under zero!");
    }

    @DisplayName("소수점 2자리까지 계산")
    @Test
    void calculate_double_until_to_2_decimal_places(){
        double amountA = 5.25;
        double amountB = 5.25;

        Currency nationalCode = Currency.USD;

        Money money1 = new Money(amountA, nationalCode);
        Money money2 = new Money(amountB, nationalCode);

        assertThat(money1.add(money2).getMoney()).isEqualTo(new Money(10.50, nationalCode).getMoney());
    }

}