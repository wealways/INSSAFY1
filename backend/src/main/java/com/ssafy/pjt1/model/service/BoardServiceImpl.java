package com.ssafy.pjt1.model.service;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.pjt1.model.dto.board.BoardDto;
import com.ssafy.pjt1.model.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private SqlSession sqlSession;

	public static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);

	@Override
	public void createBoard(BoardDto boardDto) {
		sqlSession.getMapper(BoardMapper.class).createBoard(boardDto);	
	}

	@Override
	public void subscribe(Map<String, Object> map) {
		sqlSession.getMapper(BoardMapper.class).subscribe(map);
	}

	@Override
	public void addFunction(Map<String, Object> map) {
		sqlSession.getMapper(BoardMapper.class).addFunction(map);
		
	}

	@Override
	public int isSubscribed(Map<String, Object> map) {
		return sqlSession.getMapper(BoardMapper.class).isSubscribed(map);
	}

	@Override
	public void unsubscribe(Map<String, Object> map) {
		sqlSession.getMapper(BoardMapper.class).unsubscribe(map);
		
	}

}