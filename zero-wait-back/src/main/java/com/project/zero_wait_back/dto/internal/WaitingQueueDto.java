package com.project.zero_wait_back.dto.internal;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class WaitingQueueDto {
    private Long waitingId;
    private int waitNumber;
    private int partySize;
    private LocalDateTime createdAt;
}