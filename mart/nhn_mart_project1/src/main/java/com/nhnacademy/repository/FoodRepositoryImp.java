package com.nhnacademy.repository;

import com.nhnacademy.domain.Food;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodRepositoryImp implements FoodRepository{

    private List<Food> foodList = new ArrayList<>();

    @Override
    public void add(Food food) {
        foodList.add(food);
    }

    public List<Food> getFoodList() {
        return foodList;
    }


}
