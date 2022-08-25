package com.example.kitchenservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class FoodResDto {

    private Double price;
    private Long rate;
    private String name;

}
