package com.example.kitchenservice.service;

import com.example.kitchenservice.dto.ApiResponse;
import com.example.kitchenservice.entity.Worker;
import com.example.kitchenservice.entity.enums.WorkerType;
import com.example.kitchenservice.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class WorkerServiceImpl implements WorkerService {
    private final WorkerRepository workerRepository;
    @Override
    public ApiResponse<Object> createWorker() {
      Worker worker1 = new Worker();
        worker1.setActive(true);

        worker1.setWorkerType(worker1.getWorkerType());
        worker1.setFilial(worker1.getFilial());
        worker1.setPhone(worker1.getPhone());
        worker1.setSalary(worker1.getSalary());
        worker1.setNameUz(worker1.getNameUz());
worker1.setUsername(worker1.getUsername());
        Worker save = workerRepository.save(worker1);
      return  ApiResponse.builder().message("CREATED").data(save).success(true).build();
    }


}
