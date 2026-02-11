package com.project.zero_wait_back.mapper;

import com.project.zero_wait_back.dto.request.SignUpRequestDto;
import com.project.zero_wait_back.dto.response.UserRespDto;
import com.project.zero_wait_back.entity.User;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface UserMapper {
    // 유저 등록 (Insert)
    User insertUser(SignUpRequestDto dto);

    // 전체 유저 조회 (Select)
    List<User> findAllUsers();

    // 특정 유저 조회
    User findByUserId(Long userId);
}