package com.ssafy.pjt1.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.pjt1.model.dto.board.BoardDto;
import com.ssafy.pjt1.model.dto.user.UserDto;

@Mapper
public interface BoardMapper {

	public void createBoard(BoardDto boardDto);

	public void subscribe(Map<String, Object> map);

	public void addFunction(Map<String, Object> map);

	public int isSubscribed(Map<String, Object> map);

	public void unsubscribe(Map<String, Object> map);

	public List<UserDto> getUser(String keyword);

}