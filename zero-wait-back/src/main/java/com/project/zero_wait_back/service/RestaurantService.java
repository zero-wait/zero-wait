package com.project.zero_wait_back.service;

import com.project.zero_wait_back.dto.internal.ArrivedWaitingDto;
import com.project.zero_wait_back.dto.internal.WaitingQueueDto;
import com.project.zero_wait_back.dto.response.RestaurantRespDto;
import com.project.zero_wait_back.mapper.RestaurantMapper;
import com.project.zero_wait_back.mapper.TableMapper;
import com.project.zero_wait_back.mapper.WaitingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.PriorityQueue;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    public final RestaurantMapper restaurantMapper;
    public final WaitingMapper waitingMapper;
    public final TableMapper tableMapper;

    private static final int DEFAULT_AVG_MINUTES = 60;

    public List<RestaurantRespDto> getRestaurants(Integer categoryId, Boolean isOpen) {
        List<RestaurantRespDto> list = restaurantMapper.getRestaurants(categoryId, isOpen);
        list.forEach(r -> r.setEstimatedWaitingTime(
                calculateEstimatedWaitMinutes(r.getRestaurantId())));
        return list;
    }

    private int calculateEstimatedWaitMinutes(Long restaurantId) {

        Integer avgMinutes = waitingMapper.findAvgUsageMinutes(restaurantId);
        if (avgMinutes == null || avgMinutes <= 0) avgMinutes = DEFAULT_AVG_MINUTES;

        int totalTables = tableMapper.findTotalTableCount(restaurantId);
        if (totalTables == 0) return 0;

        List<ArrivedWaitingDto> arrivedList = waitingMapper.findArrivedWaitings(restaurantId);
        int availableTables = totalTables - arrivedList.size();

        int waitingCount = waitingMapper.findWaitingQueue(restaurantId).size();

        if (availableTables >= waitingCount) return 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (ArrivedWaitingDto arrived : arrivedList) {
            int elapsed = (int) Duration.between(arrived.getSeatedAt(), LocalDateTime.now()).toMinutes();
            elapsed = Math.max(elapsed, 0); // 음수 방지
            int remaining = Math.max(avgMinutes - elapsed, 0);
            pq.offer(remaining);
        }

        for (int i = 0; i < availableTables; i++) {
            pq.offer(0);
        }

        for (int i = 0; i < waitingCount - 1; i++) {
            int releaseTime = pq.poll();
            pq.offer(releaseTime + avgMinutes);
        }

        return pq.poll();
    }
}