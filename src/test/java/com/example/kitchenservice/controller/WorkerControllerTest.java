package com.example.kitchenservice.controller;

import com.example.kitchenservice.dto.ApiResponse;
import com.example.kitchenservice.entity.Worker;
import com.example.kitchenservice.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.bind.annotation.RequestBody;

import static org.junit.jupiter.api.Assertions.*;
@RequiredArgsConstructor
@ExtendWith(MockitoExtension.class)
class WorkerControllerTest {
    private  final WorkerController workerController;
    private final WorkerRepository workerRepository;
    @Test
    @Order(1)
    public  ApiResponse<?>  addWorker(Worker worker){
        worker.setUsername("Alex23");
        worker.setNameUz("Alex");
        worker.setSalary(1200.2);
        worker.setPhone("123");
        worker.setActive(true);
        Worker save = workerRepository.save(worker);
        return ApiResponse.builder().message("ADDED").success(true).data(save).build();


    }
}