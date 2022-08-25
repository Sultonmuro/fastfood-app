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

public class OrderResDto {
    private String filial_name;

    private String foods_name;
    private Double price;
    private Date startedAt;
    private Date finishedAt;
}
