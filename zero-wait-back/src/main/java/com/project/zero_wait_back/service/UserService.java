package com.project.zero_wait_back.service;

import com.project.zero_wait_back.dto.UserDto;
import com.project.zero_wait_back.entity.User;
import com.project.zero_wait_back.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    public void createUser(UserDto dto) {
        userMapper.insertUser(dto);
    }

    public List<User> getAllUsers() {
        return userMapper.findAllUsers();
    }

}
