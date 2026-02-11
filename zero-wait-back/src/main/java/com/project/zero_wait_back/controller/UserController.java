package com.project.zero_wait_back.controller;

import com.project.zero_wait_back.dto.request.SignUpRequestDto;
import com.project.zero_wait_back.dto.response.UserRespDto;
import com.project.zero_wait_back.entity.User;
import com.project.zero_wait_back.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> createUser(@RequestBody SignUpRequestDto dto) {

        return ResponseEntity.ok(userService.createUser(dto));

    }

}
