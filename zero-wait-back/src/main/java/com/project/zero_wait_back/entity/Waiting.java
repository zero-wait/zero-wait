package com.project.zero_wait_back.entity;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Waiting {

    private Long waitingId;
    private Long userId;
    private Long restaurantId;
    private int partySize;
    private Status status;
    private Integer waitNumber;
    private int tableId;
    private LocalDateTime calledAt;
    private LocalDateTime seatedAt;
    private LocalDateTime finishedAt;
    private LocalDateTime canceledAt;
    private String cancelReason;
    private boolean isDeleted;
    private LocalDateTime createdAt;

    public enum Status {
        WAITING, CALLED, ARRIVED, FINISHED, CANCELED
    }
}