package com.project.zero_wait_back.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Restaurant {
    private Integer restaurantId;

    private Long ownerId;
    private String restaurantName;
    private String description;
    private String address;
    private String addressDetail;
    private String tel;
    private BigDecimal ratingAvg;
    private Integer reviewCount;
    private Boolean isWaiting;
}
