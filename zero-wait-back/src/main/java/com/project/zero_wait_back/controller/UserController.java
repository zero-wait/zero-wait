package com.project.zero_wait_back.controller;

import com.project.zero_wait_back.dto.UserDto;
import com.project.zero_wait_back.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
    @RequestMapping("/api/users")
        public class UserController {

            @PostMapping
            public ResponseEntity<User> createUser(@RequestBody UserDto dto) {

                User user = User.builder()
                        .password(  )
                        .build();

    }

}
