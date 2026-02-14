package com.project.zero_wait_back.controller;

import com.project.zero_wait_back.dto.request.WaitingReqDto;
import com.project.zero_wait_back.entity.Waiting;
import com.project.zero_wait_back.service.WaitingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/waiting")
@RequiredArgsConstructor
public class WaitingController {

    private final WaitingService waitingService;

    // POST 방식으로 웨이팅 등록 요청을 받음
    @PostMapping("/{restaurantId}")
    public ResponseEntity<Waiting> createWaiting(WaitingReqDto dto) {
        // 서비스의 비즈니스 로직 호출
        Waiting waiting = waitingService.createWaiting(dto);

        // 성공 응답 (200 OK와 함께 생성된 데이터 반환)
        return ResponseEntity.ok(waiting);
    }
}