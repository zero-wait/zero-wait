package com.project.zero_wait_back.dto.internal;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ArrivedWaitingDto {
    private Long waitingId;
    private Long tableId;
    private LocalDateTime seatedAt;
    private int partySize;
}