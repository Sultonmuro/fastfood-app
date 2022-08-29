package com.example.kitchenservice.entity;

import com.example.kitchenservice.entity.template.AbsEntity;
import com.example.kitchenservice.entity.template.AbsNameEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "food")

public class Food extends AbsEntity {
     private String food_name;
     private Double price;
     private Byte photo;
     private Long rate;
     @ManyToOne
    @JoinColumn(name = "foodList")
    private Menu menu;
}
