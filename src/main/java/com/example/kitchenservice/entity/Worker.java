package com.example.kitchenservice.entity;

import com.example.kitchenservice.entity.enums.WorkerType;
import com.example.kitchenservice.entity.template.AbsNameEntity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "worker")
@SQLDelete(sql = "update worker set delete= true,status =false where  id = ?")
public class Worker extends AbsNameEntity {
    @Column(unique = true)
    private String username;
    private String phone;


    @Column(nullable = false)
    private Double salary;

    private boolean active = true ;

    @Enumerated(EnumType.STRING)
    private WorkerType workerType;
 @OneToOne
    private Filial filial;

}
