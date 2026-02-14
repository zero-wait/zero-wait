package com.project.zero_wait_back.service;

import com.project.zero_wait_back.dto.request.WaitingReqDto;
import com.project.zero_wait_back.entity.Waiting;
import com.project.zero_wait_back.mapper.WaitingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class WaitingService {

    private final WaitingMapper waitingMapper;
    // userId는 로그인 로직 구현되면 principalUser에서 가져오기
    public Waiting createWaiting(WaitingReqDto dto) {

        String todayStr = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        int nextWaitNumber = waitingMapper.findLastWaitNumberByRestaurantId(dto.getRestaurantId()) + 1;

        String combinedIdStr = todayStr + String.format("%04d", nextWaitNumber);
        Long waitingId = Long.parseLong(combinedIdStr);

        Waiting waiting = Waiting.builder()
                .waitingId(waitingId)
                .userId(dto.getUserId())
                .restaurantId(dto.getRestaurantId())
                .partySize(dto.getPartySize())
                .status(Waiting.Status.WAITING)
                .waitNumber(nextWaitNumber)
                .createdAt(LocalDateTime.now())
                .isDeleted(false)
                .build();

        waitingMapper.createWaiting(waiting);

        return waiting;
    }

}
