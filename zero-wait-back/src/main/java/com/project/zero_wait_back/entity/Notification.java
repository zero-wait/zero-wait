package com.project.zero_wait_back.entity;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Notification {

    private Long notificationId;
    private Long userId;
    private Type type;
    private String title;
    private String content;
    private boolean isRead;
    private Long referenceId;
    private LocalDateTime expiredAt;
    private LocalDateTime createdAt;

    public enum Type {
        WAITING_CONFIRM, WAITING_CALL, WAITING_CANCEL, REVIEW_REQUEST
    }
}