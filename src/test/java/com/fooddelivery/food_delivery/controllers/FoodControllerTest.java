//package com.fooddelivery.food_delivery.controllers;
//
//import com.fooddelivery.food_delivery.models.Food;
//import com.fooddelivery.food_delivery.services.FoodService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNull;
//import static org.mockito.Mockito.*;
//
//public class FoodControllerTest {
//
//    private FoodController foodController;
//
//    @Mock
//    private FoodService foodService;
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.openMocks(this);
//        foodController = new FoodController(foodService);
//    }
//
//    @Test
//    @DisplayName("Test createFood")
//    public void testCreateFood() {
//        // Prepare
//        Food food = new Food("Pizza", 12.99, "some/picture/url/picture.jpg");
//        when(foodService.saveFood(food)).thenReturn(food);
//
//        // Act
//        ResponseEntity<Food> response = foodController.createFood(food);
//
//        // Assert
//        assertEquals(food, response.getBody());
//        assertEquals(HttpStatus.CREATED, response.getStatusCode());
//        verify(foodService, times(1)).saveFood(food);
//    }
//
//    @Test
//    @DisplayName("Test createFood - Invalid input")
//    public void testCreateFood_InvalidInput() {
//        // Prepare
//        Food food = new Food(null, 10.99, "some/picture/url/picture.jpg");
//
//        // Act
//        ResponseEntity<Food> response = foodController.createFood(food);
//
//        // Assert
//        assertNull(response.getBody());
//        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
//        verify(foodService, never()).saveFood(food);
//    }
//
//    @Test
//    @DisplayName("Test getAllFood")
//    public void testGetAllFood() {
//        // Prepare
//        Food food1 = new Food("Pizza", 10.99, "some/picture/url/picture1.jpg");
//        Food food2 = new Food("Pasta", 8.99, "some/picture/url/picture2.jpg");
//        List<Food> foodList = Arrays.asList(food1, food2);
//
//        when(foodService.getAllFood()).thenReturn(foodList);
//
//        // Act
//        ResponseEntity<List<Food>> response = foodController.getAllFood();
//
//        // Assert
//        assertEquals(foodList, response.getBody());
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        verify(foodService, times(1)).getAllFood();
//    }
//
//    @Test
//    @DisplayName("Test getFoodById")
//    public void testGetFoodById() {
//        // Prepare
//        Long foodId = 1L;
//        Food food = new Food("Pizza", 10.99, "some/picture/url/picture.jpg");
//
//        when(foodService.getFoodById(foodId)).thenReturn(food);
//
//        // Act
//        ResponseEntity<Food> response = foodController.getFoodById(foodId);
//
//        // Assert
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(food, response.getBody());
//    }
//
//    @Test
//    public void testGetFoodById_NonExistingId() {
//        // Prepare
//        Long nonExistingId = 123L;
//
//        when(foodService.getFoodById(nonExistingId)).thenReturn(null);
//
//        // Act
//        ResponseEntity<Food> response = foodController.getFoodById(nonExistingId);
//
//        // Assert
//        assertNull(response.getBody());
//        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
//        verify(foodService, times(1)).getFoodById(nonExistingId);
//    }
//
//    @Test
//    @DisplayName("Test updateFood")
//    public void testUpdateFoodById() {
//        // Prepare
//        Long foodId = 1L;
//        Food food = new Food("Pizza", 10.99, "some/picture/url/picture.jpg");
//
//        when(foodService.updateFoodById(foodId, food)).thenReturn(food);
//
//        // Act
//        ResponseEntity<Food> response = foodController.updateFood(foodId, food);
//
//        // Assert
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        verify(foodService, times(1)).updateFoodById(foodId, food);
//    }
//
//    @Test
//    @DisplayName("Test deleteFood")
//    public void testDeleteFood() {
//        // Prepare
//        Long foodId = 1L;
//
//        when(foodService.deleteFoodById(foodId)).thenReturn(null);
//
//        // Act
//        ResponseEntity<Void> response = foodController.deleteFood(foodId);
//
//        // Assert
//        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
//        verify(foodService, times(1)).deleteFoodById(foodId);
//    }
//}
