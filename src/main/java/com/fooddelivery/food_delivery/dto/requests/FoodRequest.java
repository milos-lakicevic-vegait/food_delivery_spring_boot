package com.fooddelivery.food_delivery.dto.requests;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class FoodRequest {
    @NotNull(message = "Name must not be null")
    @NotEmpty
    public String name;

    @NotNull(message = "Price must not be null")
    public Double price;

    @NotNull(message = "Picture must not be null")
    public String picture;
}
