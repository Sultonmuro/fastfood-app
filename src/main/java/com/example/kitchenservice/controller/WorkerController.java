package com.example.kitchenservice.controller;

import com.example.kitchenservice.dto.ApiResponse;
import com.example.kitchenservice.entity.Worker;
import com.example.kitchenservice.repository.WorkerRepository;

import com.example.kitchenservice.service.WorkerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;
 /*
   Junit Test
   uchun yozudim
   bu controllerni
   */

@RestController
@RequestMapping("/worker")
@RequiredArgsConstructor
public class WorkerController{
    private final WorkerRepository workerRepository;
    private final WorkerServiceImpl workerService;


    @GetMapping
    public ApiResponse<?> getWorkers(){
        List<Worker> all = workerRepository.findAll();
        return ApiResponse.builder().message("Read").success(true).data(all).build();

    } 
    
    @PostMapping("/add")
    public ApiResponse<Object> addWorker(@RequestBody Worker worker,@PathVariable Long id ){
        Worker save = workerRepository.saveAndFlush(worker);
 return ApiResponse.builder().data(save).message("Added successfully").success(true).build();
    }
//  @PutMapping("/edit")
//    public ApiResponse<Object> editWorker (){
//
//  }
}
