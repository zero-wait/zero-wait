package com.project.zero_wait_back.entity;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    private Long reviewId;
    private Long restaurantId;
    private Long waitingId;
    private Long userId;
    private byte rating;
    private String content;
    private int helpfulCount;
    private boolean isDeleted;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}