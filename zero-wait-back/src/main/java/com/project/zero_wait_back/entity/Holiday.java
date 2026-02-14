package com.project.zero_wait_back.entity;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Holiday {

    private Long holidayId;
    private Long restaurantId;
    private Type type;
    private Byte dayOfWeek;      // WEEKLY인 경우 1-7
    private LocalDate specificDate; // TEMPORARY인 경우
    private String reason;
    private boolean isDeleted;
    private LocalDateTime createdAt;

    public enum Type {
        WEEKLY, TEMPORARY
    }
}