package com.example.kitchenservice.config;

import com.example.kitchenservice.entity.Worker;
import com.example.kitchenservice.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@EnableWebSecurity
@Slf4j
@RequiredArgsConstructor
@Configuration
public class Filter implements UserDetailsService {
    private final WorkerRepository workerRepository;
    @Override
    public UserDetails loadUserByUsername(String workerName) throws UsernameNotFoundException {
        Worker worker = workerRepository.findWorkerByNameRu(workerName);
        if(worker == null){
            log.error("Worker not Found");
            throw  new UsernameNotFoundException("Worker not Found");
        }else {
            log.info("Worker successfully found in db {}",workerName);

        }
        return (UserDetails) new Worker(worker.getUsername(),worker.getPhone(),worker.getSalary(),worker.isActive(),worker.getWorkerType(),worker.getFilial(),worker.getOrderList());
    }

}
