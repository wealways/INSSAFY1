package com.ssafy.pjt1.model.service.post;

import java.util.Map;

import com.ssafy.pjt1.model.dto.post.PostDto;

public interface PostService {

	public void createPost(PostDto postDto);

	public PostDto getPostById(String post_id);

	public int postModify(PostDto postDto);

	public int postDelete(int post_id);

	public int isScrapped(Map<String, Object> map);

	public void scrap(Map<String, Object> map);

	public void deleteScrap(Map<String, Object> map);

}