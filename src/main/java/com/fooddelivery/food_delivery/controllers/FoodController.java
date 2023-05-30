package com.fooddelivery.food_delivery.controllers;

import com.fooddelivery.food_delivery.models.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fooddelivery.food_delivery.services.FoodService;

import java.util.List;

@RestController
public class FoodController {

    @Autowired
    private FoodService foodService;

    @PostMapping("/food")
    public Food createFood(@RequestBody Food food) {
        return foodService.saveFood(food);
    }

    @GetMapping("/food")
    public List<Food> getAllFood() {
        return foodService.getAllFood();
    }

    @GetMapping("/food/{id}")
    public Food getFoodById(@PathVariable("id") Long id) {
        return foodService.getFoodById(id);
    }

    @PutMapping("/food/{id}")
    public Food updateFood(@PathVariable("id") Long id, @RequestBody Food food) {
        return foodService.updateFoodById(id, food);
    }

    @DeleteMapping("/food/{id}")
    public String deleteFood(@PathVariable("id") Long id){
        return foodService.deleteFoodById(id);
    }
}
