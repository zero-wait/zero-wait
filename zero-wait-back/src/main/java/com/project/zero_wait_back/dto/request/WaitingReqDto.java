package com.project.zero_wait_back.dto.request;

import lombok.Data;

@Data
public class WaitingReqDto {

    private Long userId;
    private Long restaurantId;
    private int partySize;

}
