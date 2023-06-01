//package com.fooddelivery.food_delivery.services;
//
//import com.fooddelivery.food_delivery.models.Food;
//import com.fooddelivery.food_delivery.repositories.FoodRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNull;
//import static org.mockito.Mockito.*;
//
//// Extends Mockito.class ...
//public class FoodServiceImplTest {
//
//    private FoodService foodService;
//
//    // InjectMock
//    @Mock
//    private FoodRepository foodRepository;
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.openMocks(this);
//        foodService = new FoodServiceImpl(foodRepository);
//    }
//
//    @Test
//    @DisplayName("Test saveFood")
//    public void testSaveFood() {
//        // Prepare
//        Food food = new Food();
//        when(foodRepository.save(food)).thenReturn(food);
//
//        // Act
//        Food savedFood = foodService.saveFood(food);
//
//        // Assert
//        assertEquals(food, savedFood);
//        // verify ??? serialization / deserialization
//        verify(foodRepository, times(1)).save(food);
//    }
//
//    @Test
//    @DisplayName("Test getAllFood")
//    public void testGetAllFood() {
//        // Prepare
//        List<Food> foodList = Arrays.asList(new Food(), new Food());
//        when(foodRepository.findAll()).thenReturn(foodList);
//
//        // Act
//        List<Food> retrievedFoodList = foodService.getAllFood();
//
//        // Assert
//        assertEquals(foodList, retrievedFoodList);
//        verify(foodRepository, times(1)).findAll();
//    }
//
//    @Test
//    @DisplayName("Test getAllFood - Empty Database")
//    public void testGetAllFood_ReturnsNull() {
//        // Prepare
//        when(foodRepository.findAll()).thenReturn(null);
//
//        // Act
//        List<Food> result = foodService.getAllFood();
//
//        // Assert
//        assertNull(result);
//        verify(foodRepository, times(1)).findAll();
//    }
//
//    @Test
//    @DisplayName("Test getFoodById - Existing ID")
//    public void testGetFoodById_ExistingId() {
//        // Prepare
//        Long id = 1L;
//        Food food = new Food();
//        when(foodRepository.findById(id)).thenReturn(Optional.of(food));
//
//        // Act
//        Food retrievedFood = foodService.getFoodById(id);
//
//        // Assert
//        assertEquals(food, retrievedFood);
//        verify(foodRepository, times(1)).findById(id);
//    }
//
//    @Test
//    @DisplayName("Test getFoodById - Non-Existing ID")
//    public void testGetFoodById_NonExistingId() {
//        // Prepare
//        Long id = 1L;
//        when(foodRepository.findById(id)).thenReturn(Optional.empty());
//
//        // Act
//        Food retrievedFood = foodService.getFoodById(id);
//
//        // Assert
//        assertNull(retrievedFood);
//        verify(foodRepository, times(1)).findById(id);
//    }
//
//    @Test
//    @DisplayName("Test updateFoodById - Existing ID")
//    public void testUpdateFoodById() {
//        // Prepare
//        Long foodId = 1L;
//        Food existingFood = new Food();
//        existingFood.setName("Pizza");
//        existingFood.setPrice(10.99);
//        existingFood.setPicture("pizza.jpg");
//
//        Food updatedFood = new Food();
//        updatedFood.setName("Margherita Pizza");
//        updatedFood.setPrice(12.99);
//        updatedFood.setPicture("margherita_pizza.jpg");
//
//        when(foodRepository.findById(foodId)).thenReturn(Optional.of(existingFood));
//        when(foodRepository.save(existingFood)).thenReturn(existingFood);
//
//        // Act
//        Food result = foodService.updateFoodById(foodId, updatedFood);
//
//        // Assert
//        assertEquals(updatedFood.getName(), result.getName());
//        assertEquals(updatedFood.getPrice(), result.getPrice());
//        assertEquals(updatedFood.getPicture(), result.getPicture());
//        verify(foodRepository, times(1)).findById(foodId);
//        verify(foodRepository, times(1)).save(existingFood);
//    }
//
//    @Test
//    @DisplayName("Test updateFoodById - Non-Existing ID")
//    public void testUpdateFoodById_NonExistingId() {
//        // Arrange
//        Long foodId = 1L;
//        Food updatedFood = new Food();
//        updatedFood.setName("Margherita Pizza");
//        updatedFood.setPrice(12.99);
//        updatedFood.setPicture("margherita_pizza.jpg");
//
//        when(foodRepository.findById(foodId)).thenReturn(Optional.empty());
//
//        // Act
//        Food result = foodService.updateFoodById(foodId, updatedFood);
//
//        // Assert
//        assertNull(result);
//        verify(foodRepository, times(1)).findById(foodId);
//        verify(foodRepository, never()).save(any());
//    }
//
//    @Test
//    @DisplayName("Test deleteFoodById - Existing ID")
//    public void testDeleteFoodById() {
//        // Prepare
//        Long foodId = 1L;
//        Food existingFood = new Food();
//        existingFood.setName("Pizza");
//        existingFood.setPrice(10.99);
//        existingFood.setPicture("pizza.jpg");
//
//        when(foodRepository.findById(foodId)).thenReturn(Optional.of(existingFood));
//
//        // Act
//        String result = foodService.deleteFoodById(foodId);
//
//        // Assert
//        assertEquals("Food Deleted Successfully", result);
//        verify(foodRepository, times(1)).findById(foodId);
//        verify(foodRepository, times(1)).deleteById(foodId);
//    }
//
//    @Test
//    @DisplayName("Test deleteFoodById - Non-Existing ID")
//    public void testDeleteFoodById_NonExistingId() {
//        // Arrange
//        Long foodId = 1L;
//
//        when(foodRepository.findById(foodId)).thenReturn(Optional.empty());
//
//        // Act
//        String result = foodService.deleteFoodById(foodId);
//
//        // Assert
//        assertEquals("No such food in the database", result);
//        verify(foodRepository, times(1)).findById(foodId);
//        verify(foodRepository, never()).deleteById(foodId);
//    }
//}
