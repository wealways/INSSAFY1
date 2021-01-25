package com.ssafy.pjt1.model.service;

import com.ssafy.pjt1.model.dto.user.UserDto;

public interface UserService {
    public UserDto login(UserDto userDto);

    public boolean join(UserDto userDto);

    public UserDto userInfo(String user_email);
}
