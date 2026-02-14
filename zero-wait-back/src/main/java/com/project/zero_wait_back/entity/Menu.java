package com.project.zero_wait_back.entity;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Menu {

    private Long menuId;
    private Long restaurantId;
    private String name;
    private int price;
    private String description;
    private int displayOrder;
    private boolean isPopular;
    private boolean isSoldOut;
    private boolean isDeleted;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}