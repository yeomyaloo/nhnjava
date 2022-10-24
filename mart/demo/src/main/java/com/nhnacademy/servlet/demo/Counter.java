package com.nhnacademy.servlet.demo;

public class Counter {
    public int doPayment(Basket basket, int money) {
        int sum_price = 0;
        int change = 0;
        for(int i=0; i<basket.getFoods().size(); i++) {
            System.out.println(basket.getFoods().get(i).toString());
            sum_price += basket.getFoods().get(i).getPrice();
        }

        System.out.println("총 가격은 " + sum_price + "원 입니다.");

        if(money < sum_price) {
            throw new RuntimeException("죄송합니다만 고객님 돈이 부족합니다");
        }

        change = money - sum_price;
        System.out.println("결제 후 잔액: " + change);

        return money - sum_price;
    }
}
