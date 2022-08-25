package com.example.kitchenservice.repository;

import com.example.kitchenservice.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker,Long> {
 Worker findWorkerByNameRu(String workerName);
}
