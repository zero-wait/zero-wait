package com.project.zero_wait_back.entity;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {

    private Long restaurantId;
    private Integer categoryId;
    private Long ownerId;
    private String name;
    private String description;
    private String address;
    private String addressDetail;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String tel;
    private BigDecimal ratingAvg;
    private int reviewCount;
    private boolean isWaiting;
    private boolean isDeleted;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}