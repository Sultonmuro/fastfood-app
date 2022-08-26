package com.example.kitchenservice.controller;

import com.example.kitchenservice.dto.ApiResponse;
import com.example.kitchenservice.dto.OrderDto;
import com.example.kitchenservice.entity.Order;
import com.example.kitchenservice.repository.OrderRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderRepository orderRepository;


@GetMapping("/{id}")
    public ApiResponse<?> getOrder(@PathVariable Long id){
    Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Bunday Idli Buyurtma yo'q"));
   return ApiResponse.builder().message("Buyurtmani oldik").data(order).success(true).build();

}
@PutMapping("/{id}")
    public ApiResponse<?> orderChanges(@PathVariable Long id,@RequestBody OrderDto orderDto){
    Optional<Order> byId = orderRepository.findById(id);
  if ( byId.isPresent()){
      Order order  = new Order();
      order.setOrderedAt(order.getOrderedAt());
      order.setFilial(order.getFilial());
      order.setFoodList(order.getFoodList());
      order.setPrice(order.getPrice());
    order.setOrderFinishedAt(order.getOrderFinishedAt());
      Order save = orderRepository.save(order);

 return ApiResponse.builder().message("Order saved "+
         "Rate the Order if you like ").data(save).success(true).build();

  }else{
      return ApiResponse.builder().message("Maybe Order was cancelled").success(false).build();
  }

}
//    @DeleteMapping("/{id}")
//    public ApiResponse<?> delete(@PathVariable Long id ){
//        Order order =  orderRepository.findById(id).orElseThrow(() -> new NotFoundException("Bunday Idli order yo'q"));
//       orderRepository.delete(order);
//       return ApiResponse.builder().message("DELETED!").success(true).build();
//    }



  @DeleteMapping("/{id}")
    public ApiResponse<?> deleteOrder(@PathVariable Long id){
      Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Id not found "));
      orderRepository.delete(order);
   return   ApiResponse.builder().message("DELETED").success(true).build();

  }







}
