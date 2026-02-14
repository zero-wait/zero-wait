package com.project.zero_wait_back.mapper;

import com.project.zero_wait_back.entity.Waiting;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WaitingMapper {

    int createWaiting(Waiting waiting);

    int findLastWaitNumberByRestaurantId(Long restaurantId);

}
