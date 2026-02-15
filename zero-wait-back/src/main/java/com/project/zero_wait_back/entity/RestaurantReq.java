package com.project.zero_wait_back.entity;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantReq {

    private Long restaurantReqId;
    private Integer categoryId;
    private Long ownerId;
    private Long adminId;
    private Long restaurantId;
    private String businessNumber;
    private String restaurantName;
    private String address;
    private String tel;
    private int maxCapacity;
    private Status status;
    private String rejectReason;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public enum Status {
        PENDING, APPROVED, REJECTED
    }
}