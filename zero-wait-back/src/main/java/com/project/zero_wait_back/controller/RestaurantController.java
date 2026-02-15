package com.project.zero_wait_back.controller;

import com.project.zero_wait_back.dto.response.RestaurantRespDto;
import com.project.zero_wait_back.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    public final RestaurantService restaurantService;

    @GetMapping("/get")
    public ResponseEntity<List<RestaurantRespDto>> getRestaurants(
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) Boolean isOpen) {
        return ResponseEntity.ok().body(restaurantService.getRestaurants(categoryId, isOpen));
    }
}
