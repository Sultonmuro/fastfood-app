package com.example.kitchenservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class OrderDto {
    private Long filial_id;
    private List<Long> foodList_id;
    private Double price;
    private Date orderedAt;
    private Date orderFinishedAt;
    
}
