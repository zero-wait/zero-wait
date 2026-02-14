package com.project.zero_wait_back.mapper;

import com.project.zero_wait_back.dto.internal.ArrivedWaitingDto;
import com.project.zero_wait_back.dto.internal.WaitingQueueDto;
import com.project.zero_wait_back.entity.Waiting;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WaitingMapper {

    // 현재 착석 중인 웨이팅 목록
    List<ArrivedWaitingDto> findArrivedWaitings(@Param("restaurantId") Long restaurantId);

    // 현재 대기 중인 큐 (wait_number 오름차순)
    List<WaitingQueueDto> findWaitingQueue(@Param("restaurantId") Long restaurantId);

    // 최근 7일 평균 이용시간
    Integer findAvgUsageMinutes(@Param("restaurantId") Long restaurantId);

    // 마지막 대기번호 조회 (오늘)
    Integer findLastWaitNumberByRestaurantId(@Param("restaurantId") Long restaurantId);

}

