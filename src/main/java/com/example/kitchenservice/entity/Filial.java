package com.example.kitchenservice.entity;

import com.example.kitchenservice.entity.template.AbsNameEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "filial")

public class Filial extends AbsNameEntity {


    @Temporal(TemporalType.TIME)
    private Date openingTime;

    @Temporal(TemporalType.TIME)
    private Date closingTime;


    private String location;


}
