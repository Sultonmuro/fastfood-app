package com.example.kitchenservice.entity;

import com.example.kitchenservice.entity.template.AbsEntity;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "orders")

public class Order extends AbsEntity {
    @OneToOne
    private Filial filial;

    private Double price;


    @Temporal(TemporalType.TIMESTAMP)
    private Date orderedAt;

    @OneToMany
    private List<Food> foodList;


    @Temporal(TemporalType.TIMESTAMP)
    private Date orderFinishedAt ;





}
