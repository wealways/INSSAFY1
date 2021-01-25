package com.ssafy.pjt1.model.service;

import java.util.Map;

import com.ssafy.pjt1.model.dto.user.UserDto;

public interface UserService {
    public UserDto login(UserDto userDto);

    public boolean join(UserDto userDto);
    
    public UserDto emailCheck(String user_email);
	
	public String getId();
	
	public void updateAuthKey(Map<String, String> map);

	public void updateAuthStatus(String email);
	
//	public String sendAuthMail(String email);
}
