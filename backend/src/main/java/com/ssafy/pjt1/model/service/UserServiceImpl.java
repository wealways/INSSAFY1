package com.ssafy.pjt1.model.service;

import com.ssafy.pjt1.model.dto.user.UserDto;
import com.ssafy.pjt1.model.mapper.UserMapper;

import java.io.UnsupportedEncodingException;

import java.util.HashMap;

import java.util.Map;
import java.util.Random;

import javax.mail.MessagingException;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private SqlSession sqlSession;

	public static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public UserDto login(UserDto userDto) {
		return sqlSession.getMapper(UserMapper.class).login(userDto);
	}

	@Override
	public boolean join(UserDto userDto) {
		return sqlSession.getMapper(UserMapper.class).join(userDto) == 1;
	}

	@Override
	public UserDto emailCheck(String user_email) {
		return sqlSession.getMapper(UserMapper.class).emailCheck(user_email);
	}

	@Override
	public String getId() {
		Random random = new Random();
		StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < 13; i++) {
			int rIndex = random.nextInt(3);
			switch (rIndex) {
				case 0:
					// a-z
					buffer.append((char) ((int) (random.nextInt(26)) + 97));
					break;
				case 1:
					// A-Z
					buffer.append((char) ((int) (random.nextInt(26)) + 65));
					break;
				case 2:
					// 0-9
					buffer.append((random.nextInt(10)));
					break;
			}
		}
		return buffer.toString();
	}

	@Override
	public void updateAuthKey(Map<String, String> map) {
		sqlSession.getMapper(UserMapper.class).updateAuthKey(map);

	}

	@Override
	public void updateAuthStatus(Map<String, String> map) {
		sqlSession.getMapper(UserMapper.class).updateAuthStatus(map);
	}

	@Override
	public UserDto userInfo(String user_email) {
		return sqlSession.getMapper(UserMapper.class).userInfo(user_email);
	}

	@Override
	public void updatePw(Map<String, String> map) {
		sqlSession.getMapper(UserMapper.class).updatePw(map);
	}

	@Override
	public int userModify(UserDto userDto) {
		return sqlSession.getMapper(UserMapper.class).userModify(userDto);
	}

}