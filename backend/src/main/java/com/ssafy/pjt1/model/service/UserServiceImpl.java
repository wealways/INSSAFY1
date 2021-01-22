package com.ssafy.pjt1.model.service;

import com.ssafy.pjt1.model.dto.user.UserDto;
import com.ssafy.pjt1.model.mapper.UserMapper;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
}