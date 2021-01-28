package com.ssafy.pjt1.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.pjt1.model.dto.board.BoardDto;
import com.ssafy.pjt1.model.dto.user.UserDto;
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

	@Override
	public List<UserDto> searchUser(String keyword) {
		return sqlSession.getMapper(BoardMapper.class).searchUser(keyword);
	}

	@Override
	public void updateManager(Map<String, Object> map) {
		sqlSession.getMapper(BoardMapper.class).updateManager(map);
	}

	@Override
	public int modifyBoard(BoardDto boardDto) {
		return sqlSession.getMapper(BoardMapper.class).modifyBoard(boardDto);
	}

	@Override
	public List<BoardDto> getBoardsNew() {
		return sqlSession.getMapper(BoardMapper.class).getBoardsNew();
	}

	@Override
	public List<BoardDto> getBoardsPopular() {
		return sqlSession.getMapper(BoardMapper.class).getBoardsPopular();
	}

	@Override
	public List<BoardDto> searchBoardNew(String keyword) {
		return sqlSession.getMapper(BoardMapper.class).searchBoardNew(keyword);
	}

	@Override
	public List<BoardDto> searchBoardPopular(String keyword) {
		return sqlSession.getMapper(BoardMapper.class).searchBoardPopular(keyword);
	}

	@Override
	public int boardDelete(int board_id) {
		return sqlSession.getMapper(BoardMapper.class).boardDelete(board_id);
	}

}