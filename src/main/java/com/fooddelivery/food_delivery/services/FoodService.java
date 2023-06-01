package com.fooddelivery.food_delivery.services;

import com.fooddelivery.food_delivery.models.Food;

import java.util.List;
import java.util.Optional;

public interface FoodService {
    Food saveFood(Food food);
    List<Food> getAllFood();

    Food getFoodById(Long id);

    Food updateFoodById(Long id, Food food);

    String deleteFoodById(Long id);
}
