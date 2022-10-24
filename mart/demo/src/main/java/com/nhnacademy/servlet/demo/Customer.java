package com.nhnacademy.servlet.demo;

public class Customer {
    // 고객의 구매 목록
    private final BuyList buyList;
    // 고객의 장바구니
    private Basket basket;

    private int pocket_money;

    public Customer(BuyList buyList) {
        this.buyList = buyList;
        this.pocket_money = 20000;
    }

    // 장바구니를 챙김
    public void bring(Basket basket) {
        this.basket = basket;
    }

    // 장바구니에 물건 추가.
    public void pickFoods(FoodStand foodStand) {
        for(int i=0; i<buyList.getItems().size(); i++) {
            for(int j=0; j<buyList.getItems().get(i).getAmount(); j++) {
                basket.add(foodStand.getFood(buyList.getItems().get(i).getName()));
            }
        }
    }

    public void payTox(Counter counter) {
        counter.doPayment(basket,pocket_money);
    }
}
