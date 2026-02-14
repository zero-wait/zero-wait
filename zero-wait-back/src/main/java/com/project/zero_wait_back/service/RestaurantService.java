package com.project.zero_wait_back.service;

import com.project.zero_wait_back.dto.response.RestaurantRespDto;
import com.project.zero_wait_back.mapper.RestaurantMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    public final RestaurantMapper restaurantMapper;

    public List<RestaurantRespDto> getAllRestaurant() {
        return restaurantMapper.getAllRestaurant();
    }
    public List<RestaurantRespDto> getRestaurantByCategory() {
        return restaurantMapper.getRestaurantByCategory();
    }
    public List<RestaurantRespDto> getAllOpenRestaurant() {
        return restaurantMapper.getAllOpenRestaurant();
    }
    public List<RestaurantRespDto> getRestaurantSortByRating() {
        return restaurantMapper.getRestaurantSortByRating();
    }

}
