package com.project.zero_wait_back.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TableMapper {

    // 총 테이블 수 조회
    int findTotalTableCount(@Param("restaurantId") Long restaurantId);
}
