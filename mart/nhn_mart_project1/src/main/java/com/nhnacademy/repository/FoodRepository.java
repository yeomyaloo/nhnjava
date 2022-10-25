package com.nhnacademy.repository;

import com.nhnacademy.domain.Food;
import java.util.List;

public interface FoodRepository {

    public void add(Food food);

    public List<Food> getFoodList();

}
