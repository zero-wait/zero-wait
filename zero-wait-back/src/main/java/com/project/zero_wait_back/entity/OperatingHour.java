package com.project.zero_wait_back.entity;

import lombok.*;

import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OperatingHour {

    private Long opHourId;
    private Long restaurantId;
    private byte dayOfWeek;   // 1: 월 7: 일
    private boolean isDayOff;
    private LocalTime openTime;
    private LocalTime closeTime;
    private LocalTime breakStart;
    private LocalTime breakEnd;
}