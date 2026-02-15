package com.project.zero_wait_back.service;

import com.project.zero_wait_back.dto.internal.ArrivedWaitingDto;
import com.project.zero_wait_back.dto.internal.WaitingQueueDto;
import com.project.zero_wait_back.dto.response.RestaurantRespDto;
import com.project.zero_wait_back.mapper.RestaurantMapper;
import com.project.zero_wait_back.mapper.WaitingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    public final RestaurantMapper restaurantMapper;
    public final WaitingMapper waitingMapper;

    private static final int DEFAULT_AVG_MINUTES = 30;

    public List<RestaurantRespDto> getRestaurants(Integer categoryId, Boolean isOpen) {
        List<RestaurantRespDto> list = restaurantMapper.getRestaurants(categoryId, isOpen);
        list.forEach(r -> r.setEstimatedWaitingTime(
                calculateEstimatedWaitMinutes(r.getRestaurantId(), r.getMaxCapacity())));
        return list;
    }

    /**
     * 예상 대기시간 계산
     *
     * 핵심 로직:
     * - 현재 착석 인원 + 1번 대기팀 인원 <= maxCapacity → 즉시 입장 (0분)
     * - 그렇지 않으면 착석 중인 팀들이 나가는 순서대로 시뮬레이션하여
     *   1번 대기팀이 들어갈 수 있는 시점의 잔여시간 반환
     * - 순서는 절대 바꾸지 않음 (1번 대기팀 기준으로만 계산)
     */
    private int calculateEstimatedWaitMinutes(Long restaurantId, int maxCapacity) {

        if (maxCapacity <= 0) return 0;

        // 최근 7일 평균 식사시간 (없으면 기본값 30분)
        Integer avgMinutes = waitingMapper.findAvgUsageMinutes(restaurantId);
        if (avgMinutes == null || avgMinutes <= 0) avgMinutes = DEFAULT_AVG_MINUTES;

        // 현재 대기 큐 확인
        List<WaitingQueueDto> waitingQueue = waitingMapper.findWaitingQueue(restaurantId);
        if (waitingQueue.isEmpty()) return 0;

        // 현재 착석 중인 팀 목록
        List<ArrivedWaitingDto> arrivedList = waitingMapper.findArrivedWaitings(restaurantId);

        // 현재 착석 중인 총 인원
        int currentOccupied = arrivedList.stream()
                .mapToInt(ArrivedWaitingDto::getPartySize)
                .sum();

        // 1번 대기팀 인원
        int firstPartySize = waitingQueue.get(0).getPartySize();

        // 즉시 입장 가능한 경우
        if (currentOccupied + firstPartySize <= maxCapacity) return 0;

        // 각 착석팀의 잔여 식사시간 계산 후 오름차순 정렬 (먼저 나갈 팀부터)
        LocalDateTime now = LocalDateTime.now();
        List<int[]> teamList = new ArrayList<>(); // [잔여시간(분), partySize]

        for (ArrivedWaitingDto arrived : arrivedList) {
            long elapsed = Duration.between(arrived.getSeatedAt(), now).toMinutes();
            int remaining = (int) Math.max(avgMinutes - elapsed, 0);
            teamList.add(new int[]{remaining, arrived.getPartySize()});
        }
        teamList.sort(Comparator.comparingInt(t -> t[0]));

        // 시뮬레이션: 팀이 나갈 때마다 occupied 감소
        // 1번 대기팀이 들어갈 수 있는 공간이 생기면 그 시점의 잔여시간 반환
        int occupied = currentOccupied;
        int waitTime = 0;

        for (int[] team : teamList) {
            int releaseTime = team[0]; // 이 팀이 나가는 시점 (분)
            int partySize   = team[1];

            occupied -= partySize;
            waitTime  = releaseTime;

            if (occupied + firstPartySize <= maxCapacity) break;
        }

        return waitTime;
    }
}