package com.fooddelivery.food_delivery.dto.responses;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoodResponse {
    private Long id;

    private String name;

    private Double price;

    private String picture;
}
