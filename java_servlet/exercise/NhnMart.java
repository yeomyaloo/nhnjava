package exercise;

import exercise.BuyList.Item;
import java.util.Arrays;
import java.util.Map;
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
        // Scanner에서 buyList 만들기
        //        BuyList buyList = new BuyList();
//        buyList.add(new BuyList.Item("양파", 2));
//        buyList.add(new BuyList.Item("계란", 3));

        Scanner sc = new Scanner(System.in);
        BuyList buyList = new BuyList();


        String buying = sc.nextLine();
        String[] list = null;

        int[] stockNum = new int[100];
        String[] kind = new String[100];

        list = buying.split(" ");

        for (int i = 0; i < list.length; i++){
            if (i % 2 != 0){
                stockNum[i] = Integer.parseInt(list[i]);
            }else {
                kind[i] = list[i];
            }
        }

        for (int i = 0; i < stockNum.length; i++) {
            buyList.add(new BuyList.Item(kind[i], stockNum[i]));
        }

        // TODO
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
        return foodStand;
    }


    public Counter getCounter() {
        return counter;
    }
}
