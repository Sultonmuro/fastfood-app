package com.example.kitchenservice.entity;

import com.example.kitchenservice.entity.Food;
import com.example.kitchenservice.entity.template.AbsNameEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "menu")
public class Menu extends AbsNameEntity {

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    private List<Food> foodList;





}
