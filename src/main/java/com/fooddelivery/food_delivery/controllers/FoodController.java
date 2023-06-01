package com.fooddelivery.food_delivery.controllers;

import com.fooddelivery.food_delivery.dto.requests.FoodRequest;
import com.fooddelivery.food_delivery.dto.responses.FoodResponse;
import com.fooddelivery.food_delivery.models.Food;
import com.fooddelivery.food_delivery.services.FoodService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping
    public ResponseEntity<FoodResponse> createFood(@RequestBody @Valid FoodRequest foodRequest) {
        FoodResponse createdFood = foodService.saveFood(foodRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFood);
    }

    @GetMapping
    public ResponseEntity<List<FoodResponse>> getAllFood() {
        List<FoodResponse> foodList = foodService.getAllFood();
        return ResponseEntity.status(HttpStatus.OK).body(foodList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodResponse> getFoodById(@PathVariable("id") Long id) {
        FoodResponse food = foodService.getFoodById(id);
        return ResponseEntity.status(HttpStatus.OK).body(food);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FoodResponse> updateFood(@PathVariable("id") Long id, @RequestBody @Valid FoodRequest food) {
        FoodResponse updatedFood = foodService.updateFoodById(id, food);
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
