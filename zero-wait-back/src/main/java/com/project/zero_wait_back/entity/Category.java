package com.project.zero_wait_back.entity;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    private Integer categoryId;
    private String name;
    private String description;
    private int displayOrder;
    private boolean isActive;
}