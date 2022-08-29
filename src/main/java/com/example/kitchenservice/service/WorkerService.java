package com.example.kitchenservice.service;

import com.example.kitchenservice.dto.ApiResponse;
import org.springframework.stereotype.Service;

@Service
public interface WorkerService {
    ApiResponse<Object> createWorker();



}
