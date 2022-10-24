package com.nhnacademy.servlet.demo;

import java.util.Arrays;
import java.util.Scanner;

class NhnMartShell {
    public static void main(String[] args) {
        NhnMart mart = new NhnMart();
        mart.prepareMart();

        BuyList buyList = inputBuyListFromShell();

        Customer jordan = new Customer(buyList);
        // 장바구니를 챙긴다.
        jordan.bring(mart.provideBasket());
        // 식품을 담는다.
        jordan.pickFoods(mart.getFoodStand());
        // 카운터에서 계산한다.
        jordan.payTox(mart.getCounter());
    }

    private static BuyList inputBuyListFromShell() {

        String foodNames = "양파,계란,파,사과";

        System.out.println("NHN 마트에 오신 것을 환영합니다. 사고 싶은 물건을 골라주세요. 형식: 이름 개수");
        // Scanner에서 buyList 만들기
        BuyList buyList = new BuyList();
//        buyList.add(new BuyList.Item("양파", 2));
//        buyList.add(new BuyList.Item("계란", 3));
        // TODO
        Scanner scanner = new Scanner(System.in);
        String  order = scanner.nextLine();
        String[] orders = order.split(" ");

        System.out.println(Arrays.toString(orders));

        if(orders.length%2 == 1 || orders.length < 2) {
            throw new RuntimeException("정확한 주문을 해주세요!");
        }

        String[] orderFoodNames = new String[orders.length/2];
        int[] orderFoodNumbers = new int[orders.length/2];

        int nameCount = 0;
        int numberCount = 0;
        // 올바른 입력 검사.
        for(int i=0; i<orders.length; i++) {

            if(i%2 ==0) {
                if(!foodNames.contains(orders[i])) {
                    throw new RuntimeException("음식 이름이 올바르지 않습니다!");
                }
                if(orders[i].equals("양파")) {
                    orderFoodNames[nameCount] = "양파";
                }
                else if(orders[i].contains("계란")) {
                    orderFoodNames[nameCount] = "계란(30개)";
                }
                else if(orders[i].equals("파")) {
                    orderFoodNames[nameCount] = "파";
                }
                else if(orders[i].equals("사과")) {
                    orderFoodNames[nameCount] = "사과";
                }
                else {
                    throw new RuntimeException("마트에 없는 음식이름이거나 올바르지 않은 이름입니다!");
                }
                nameCount++;
            }
            if(i%2 == 1) {
                try {
                    orderFoodNumbers[numberCount] = Integer.parseInt(orders[i]);
                    numberCount++;
                } catch (Exception e) {
                    throw new RuntimeException("음식 개수가 올바르지 않습니다!");
                }
            }
        }

        for(int i=0; i<orderFoodNames.length; i++) {
            buyList.add(new BuyList.Item(orderFoodNames[i],orderFoodNumbers[i]));
        }

        return buyList;
    }
}

public class NhnMart {
    private final FoodStand foodStand = new FoodStand();

    private final Counter counter = new Counter();

    public void prepareMart() {
        fillFoodStand();
    }

    private void fillFoodStand() {
        for (int i = 0; i < 2; i++) {
            foodStand.add(new Food("양파", 1_000));
        }
        for (int i = 0; i < 5; i++) {
            foodStand.add(new Food("계란(30개)", 5_000));
        }
        for (int i = 0; i < 10; i++) {
            foodStand.add(new Food("파", 500));
        }
        for (int i = 0; i < 20; i++) {
            foodStand.add(new Food("사과", 2_000));
        }
    }

    public Basket provideBasket() {
        return new Basket();
    }

    public FoodStand getFoodStand() {
        return this.foodStand;
    }

    public Counter getCounter() {
        return this.counter;
    }
}
