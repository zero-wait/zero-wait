package com.project.zero_wait_back.mapper;

import com.project.zero_wait_back.dto.response.RestaurantRespDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RestaurantMapper {

    List<RestaurantRespDto> getAllRestaurant();

    List<RestaurantRespDto> getRestaurantByCategory();

    List<RestaurantRespDto> getAllOpenRestaurant();

    List<RestaurantRespDto> getRestaurantSortByRating();

}
