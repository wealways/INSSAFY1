package com.ssafy.pjt1.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.pjt1.model.dto.subscription.Subscription;
import com.ssafy.pjt1.model.dto.user.UserDto;

public interface UserService {
    public UserDto login(UserDto userDto);

    public boolean join(UserDto userDto);

    public UserDto emailCheck(String user_email);

    public String getId();

    public void updateAuthKey(Map<String, String> map);

    public void updateAuthStatus(Map<String, String> map);

    public UserDto userInfo(String user_id);
    // public String sendAuthMail(String email);

    public void updatePw(Map<String, String> map);

    public int userModify(UserDto userDto);

    public int userDelete(String user_id);

    public List<Subscription> getSubBoards(String user_id);
}
