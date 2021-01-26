package com.ssafy.pjt1.model.mapper;

import com.ssafy.pjt1.model.dto.user.UserDto;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public UserDto login(UserDto userDto);

    public int join(UserDto userDto);

    public UserDto emailCheck(String user_email);

    public void updateAuthKey(Map<String, String> map);

    public void updateAuthStatus(Map<String, String> map);

    public UserDto userInfo(String user_email);

    public void updatePw(Map<String, String> map);

    public int userModify(UserDto userDto);

}
