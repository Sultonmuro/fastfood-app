package com.example.kitchenservice.controller;

import com.example.kitchenservice.dto.ApiResponse;
import com.example.kitchenservice.dto.FoodDto;
import com.example.kitchenservice.entity.Food;
import com.example.kitchenservice.repository.FoodRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/food")
@RequiredArgsConstructor
public class FoodController {
    private final FoodRepository foodRepository;

    @GetMapping
    public ApiResponse<?> getFoodList(){
        List<?> all = foodRepository.findAll();
        return ApiResponse.builder().data(all).message("READ").success(true).build();
    }

    @PostMapping("/{id}")
    public  ApiResponse<?> addFoodToMenu(@PathVariable Long id,@RequestBody FoodDto foodDto){
        Optional<Food> byId = foodRepository.findById(id);
if(byId.isPresent()){
   return ApiResponse.builder().message("You can't add food for existing id!!!").success(false).build();
}
Food food = new Food();
food.setFood_name(food.getFood_name());
food.setMenu(food.getMenu());
food.setPrice(food.getPrice());
food.setRate(food.getRate());
Food save = foodRepository.save(food);
return ApiResponse.builder().message("Added!").success(true).data(save).build();
    }
@DeleteMapping("/{id}")
    public ApiResponse<?> deleteFoodFromMenu(@PathVariable Long id) {
    Food food = foodRepository.findById(id).orElseThrow(() -> new RuntimeException("Bunday Idli Food yoq"));
    foodRepository.delete(food);

    return ApiResponse.builder().success(true).message("DELETED").build();


}

}
