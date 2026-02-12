package com.project.zero_wait_back.entity;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int userId;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private UserRole role;
    private UserStatus status;
    private LocalDateTime createdAt;

    public enum UserRole { USER, OWNER, ADMIN }
    public enum UserStatus { ACTIVE, SUSPENDED, DELETED }
}
