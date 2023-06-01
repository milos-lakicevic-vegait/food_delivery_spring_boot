package com.fooddelivery.food_delivery.controllers;

import com.fooddelivery.food_delivery.models.Food;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fooddelivery.food_delivery.services.FoodService;

import java.util.List;

@RestController
@RequestMapping("/api/food")
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping
    public ResponseEntity<Food> createFood(@RequestBody Food food) {
        Food createdFood = foodService.saveFood(food);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFood);
    }

    @GetMapping
    public ResponseEntity<List<Food>> getAllFood() {
        List<Food> foodList = foodService.getAllFood();
        return ResponseEntity.status(HttpStatus.OK).body(foodList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Food> getFoodById(@PathVariable("id") Long id) {
        Food food = foodService.getFoodById(id);
        return ResponseEntity.status(HttpStatus.OK).body(food);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Food> updateFood(@PathVariable("id") Long id, @RequestBody Food food) {
        Food updatedFood = foodService.updateFoodById(id, food);
        return ResponseEntity.status(HttpStatus.OK).body(updatedFood);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFood(@PathVariable("id") Long id){
        String result = foodService.deleteFoodById(id);
        if (result.equalsIgnoreCase("Food Deleted Successfully")) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
