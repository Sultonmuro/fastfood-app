package com.example.kitchenservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class FoodDto {
    private Long id;
    private Long menu_id;
    private Double price;
    private Long rate;

}
