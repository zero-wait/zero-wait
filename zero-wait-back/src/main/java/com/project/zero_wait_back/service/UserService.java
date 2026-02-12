package com.project.zero_wait_back.service;

import com.project.zero_wait_back.dto.request.SignUpRequestDto;
import com.project.zero_wait_back.dto.response.UserRespDto;
import com.project.zero_wait_back.entity.User;
import com.project.zero_wait_back.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    public User createUser(SignUpRequestDto dto) {

        String encodedPassword = passwordEncoder.encode(dto.getPassword());
        return userMapper.insertUser(dto);

    }

    public List<User> getAllUsers() {
        return userMapper.findAllUsers();
    }

}
