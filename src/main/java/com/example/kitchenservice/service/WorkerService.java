package com.example.kitchenservice.service;

import com.example.kitchenservice.entity.Worker;
import com.example.kitchenservice.entity.enums.WorkerType;
import org.springframework.stereotype.Service;

@Service
public interface WorkerService {
      void  createWorker(Worker worker);


}
