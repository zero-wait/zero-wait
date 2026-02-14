package com.project.zero_wait_back.entity;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long userId;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private Role role;
    private Status status;
    private boolean isDeleted = false;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public enum Role {
        USER, OWNER, ADMIN
    }
    public enum Status {
        ACTIVE, SUSPENDED, DELETED
    }

}
