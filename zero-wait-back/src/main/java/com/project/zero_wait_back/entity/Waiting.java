package com.project.zero_wait_back.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Waiting {

    private Integer waitingId;
    private Long userId;
    private Integer restaurantId;
    private Integer party;
    private WaitingStatus status;
    private LocalDateTime calledAt;
    private LocalDateTime seatedAt;
    private LocalDateTime createdAt;

    public enum WaitingStatus { WAITING, CALLED, ARRIVED, FINISHED, CANCELED }

}