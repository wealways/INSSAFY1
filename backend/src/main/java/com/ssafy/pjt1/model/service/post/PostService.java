package com.ssafy.pjt1.model.service.post;

import java.util.List;
import java.util.Map;

import com.ssafy.pjt1.model.dto.comment.CommentDto;
import com.ssafy.pjt1.model.dto.post.PostDto;

public interface PostService {

	public void createPost(PostDto postDto);

	public PostDto getPostById(int post_id);

	public int postModify(PostDto postDto);

	public int postDelete(int post_id);

	public int isScrapped(Map<String, Object> map);

	public void scrap(Map<String, Object> map);

	public void deleteScrap(Map<String, Object> map);

	public int isLiked(Map<String, Object> map);

	public void like(Map<String, Object> map);

	public void plusCount(int post_id);

	public void unlike(Map<String, Object> map);

	public void minusCount(int post_id);

	public int getLikeCount(int post_id);

	public List<CommentDto> getComment(int post_id);

}