package com.example.kitchenservice.controller;

import com.example.kitchenservice.dto.ApiResponse;
import com.example.kitchenservice.entity.Worker;
import com.example.kitchenservice.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/worker")
@RequiredArgsConstructor
public class WorkerController{
    private final WorkerRepository workerRepository;
    @GetMapping
    public ApiResponse<?> getWorkers(){
        List<Worker> all = workerRepository.findAll();
        return ApiResponse.builder().message("Read").success(true).data(all).build();
    }
}
