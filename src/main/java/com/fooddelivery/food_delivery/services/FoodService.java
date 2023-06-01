package com.fooddelivery.food_delivery.services;

import com.fooddelivery.food_delivery.dto.requests.FoodRequest;
import com.fooddelivery.food_delivery.dto.responses.FoodResponse;
import com.fooddelivery.food_delivery.exceptions.ItemNotFoundException;
import com.fooddelivery.food_delivery.models.Food;
import com.fooddelivery.food_delivery.repositories.FoodRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;

@Service
public class FoodService {

    private final FoodRepository foodRepository;
    private final ModelMapper foodMapper;


    public FoodService(FoodRepository foodRepository, ModelMapper foodMapper) {

        this.foodRepository = foodRepository;
        this.foodMapper = foodMapper;
    }

    public FoodResponse saveFood(FoodRequest foodRequest) {
        Food food = foodMapper.map(foodRequest, Food.class);
        foodRepository.save(food);
        return foodMapper.map(food, FoodResponse.class);
    }

    public List<FoodResponse> getAllFood() {
        return foodRepository.findAll().stream().map(food -> foodMapper.map(food, FoodResponse.class)).toList();
    }

    public FoodResponse getFoodById(Long id) {
        return foodRepository.findById(id).map(food -> foodMapper.map(food, FoodResponse.class))
                .orElseThrow(() -> new ItemNotFoundException("Food Not Found"));
    }

    public FoodResponse updateFoodById(Long id, FoodRequest foodRequest) {
        Food oldFood = foodRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Food Not Found"));
        oldFood.setName(foodRequest.getName());
        oldFood.setPrice(foodRequest.getPrice());
        oldFood.setPicture(foodRequest.getPicture());
        Food updatedFood = foodRepository.save(oldFood);
        return foodMapper.map(updatedFood, FoodResponse.class);
    }

    public String deleteFoodById(Long id) {
        if (foodRepository.findById(id).isPresent()) {
            foodRepository.deleteById(id);
            return "Food Deleted Successfully";
        }
        return "No such food in the database";
    }
}
