package com.nhnacademy.servlet.demo;

import java.util.ArrayList;

public class FoodStand {
    private final ArrayList<Food> foods = new ArrayList<>();

    public void add(Food onion1) {
        foods.add(onion1);
    }

    public Food getFood(String foodName) {

        try {
            for (int i = 0; i < foods.size(); i++) {
                if (foods.get(i).getName().equals(foodName)) {
                    return foods.remove(i);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("죄송합니다!" + foodName + "재고가 부족합니다. ");
        }
        throw new RuntimeException("죄송합니다!" + foodName + "재고가 부족합니다. ");
    }

}
