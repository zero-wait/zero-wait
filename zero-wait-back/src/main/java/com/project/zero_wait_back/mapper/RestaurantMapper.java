package com.project.zero_wait_back.mapper;

import com.project.zero_wait_back.dto.response.RestaurantRespDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RestaurantMapper {

    List<RestaurantRespDto> getRestaurants(
            @Param("categoryId") Integer categoryId,
            @Param("isOpen") Boolean isOpen);
}