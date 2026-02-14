package com.project.zero_wait_back.controller;

import com.project.zero_wait_back.dto.response.RestaurantRespDto;
import com.project.zero_wait_back.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    public final RestaurantService restaurantService;

    @GetMapping("/getAllRestaurant")
    public ResponseEntity<List<RestaurantRespDto>> getAllRestaurant() {
        return ResponseEntity.ok().body(restaurantService.getAllRestaurant());
    }

}
