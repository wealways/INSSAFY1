package com.ssafy.pjt1.model.service;

import com.ssafy.pjt1.model.dto.subscription.Subscription;
import com.ssafy.pjt1.model.dto.user.UserDto;
import com.ssafy.pjt1.model.mapper.UserMapper;

import java.io.UnsupportedEncodingException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.mail.MessagingException;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

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
		int num = 0;

		while (buffer.length() < 13) {
			num = random.nextInt(10);
			buffer.append(num);
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

	@Override
	public int userDelete(String user_id) {
		return sqlSession.getMapper(UserMapper.class).userDelete(user_id);
	}

	@Override
	public List<Subscription> getSubBoards(String user_id) {
		// TODO Auto-generated method stub
		return null;
	}

}