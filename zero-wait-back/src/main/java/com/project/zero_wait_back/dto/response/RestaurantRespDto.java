package com.project.zero_wait_back.dto.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RestaurantRespDto {

    private String name;
    private String address;
    private String tel;
    private String imageUrl;
    private BigDecimal ratingAvg;
    private Integer categoryId;
    private int isOpen;
    private int waitingCount;
    private int estimatedWaitingTime;

}
