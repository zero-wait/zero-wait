package com.project.zero_wait_back.entity;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Image {

    private Long imageId;
    private String imageUrl;
    private TargetType targetType;
    private Long targetId;
    private int displayOrder;
    private Integer fileSize;
    private LocalDateTime createdAt;

    public enum TargetType {
        RESTAURANT, MENU, REVIEW
    }
}