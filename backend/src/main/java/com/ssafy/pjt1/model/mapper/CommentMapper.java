package com.ssafy.pjt1.model.mapper;

import com.ssafy.pjt1.model.dto.comment.CommentDto;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {

	// public PostDto getPostById(String post_id);

	// public int postDelete(int post_id);

	public void createComment(CommentDto commentDto);

	public int commentModify(CommentDto commentDto);

	public int commentDelete(int comment_id);

	public void createNotification(int comment_id);

}