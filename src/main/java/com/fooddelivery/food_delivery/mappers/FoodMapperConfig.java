package com.fooddelivery.food_delivery.mappers;

import com.fooddelivery.food_delivery.dto.requests.FoodRequest;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FoodMapperConfig {
    @Bean
    public ModelMapper foodMapper() {
        return new ModelMapper();
    }
}
