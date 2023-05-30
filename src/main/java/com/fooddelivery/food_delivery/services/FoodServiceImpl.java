package com.fooddelivery.food_delivery.services;

import com.fooddelivery.food_delivery.models.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fooddelivery.food_delivery.repositories.FoodRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class FoodServiceImpl implements FoodService{

    @Autowired
    private FoodRepository foodRepository;

    @Override
    public Food saveFood(Food food) {
        return foodRepository.save(food);
    }

    @Override
    public List<Food> getAllFood() {
        return foodRepository.findAll();
    }

    @Override
    public Food getFoodById(Long id) {
        Optional<Food> food = foodRepository.findById(id);
        return food.orElse(null);
    }

    @Override
    public Food updateFoodById(Long id, Food food) {
        Optional<Food> food1 = foodRepository.findById(id);
        if (food1.isPresent()) {
            Food oldFood = food1.get();
            if (Objects.nonNull(food.getName()) && !"".equalsIgnoreCase(food.getName())) {
                oldFood.setName(food.getName());
            }
            if (Objects.nonNull(food.getPrice())){
                oldFood.setPrice(food.getPrice());
            }
            if (Objects.nonNull(food.getPicture()) && !"".equalsIgnoreCase(food.getPicture())) {
                oldFood.setPicture(food.getPicture());
            }
            return foodRepository.save(oldFood);
        }
        return null;
    }

    @Override
    public String deleteFoodById(Long id) {
        if (foodRepository.findById(id).isPresent()) {
            foodRepository.deleteById(id);
            return "Food Deleted Successfully";
        }
        return "No such food in the database";
    }
}
