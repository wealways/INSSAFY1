package com.ssafy.pjt1.model.service.comment;

import com.ssafy.pjt1.model.dto.comment.CommentDto;

public interface CommentService {

	// public PostDto getPostById(String post_id);

	public void createComment(CommentDto commentDto);

	public int commentModify(CommentDto commentDto);

	public int commentDelete(int comment_id);

	public void createNotification(int comment_id);

}