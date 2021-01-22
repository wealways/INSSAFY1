package com.ssafy.pjt1.model.mapper;

import com.ssafy.pjt1.model.dto.user.UserDto;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public UserDto login(UserDto userDto);

    public int join(UserDto userDto);
}
