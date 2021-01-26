package com.ssafy.pjt1.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.pjt1.model.dto.board.BoardDto;
import com.ssafy.pjt1.model.dto.user.UserDto;

public interface BoardService {

	public void createBoard(BoardDto boardDto);

	public void subscribe(Map<String, Object> map);

	public void addFunction(Map<String, Object> map);

	public int isSubscribed(Map<String, Object> map);

	public void unsubscribe(Map<String, Object> map);

	public List<UserDto> getUserList(String keyword);

}
