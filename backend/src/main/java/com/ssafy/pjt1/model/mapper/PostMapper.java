package com.ssafy.pjt1.model.mapper;

import java.util.Map;

import com.ssafy.pjt1.model.dto.post.PostDto;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostMapper {

	public void createPost(PostDto postDto);

	public PostDto getPostById(String post_id);

	public int postModify(PostDto postDto);

	public int postDelete(int post_id);

	public int isScrapped(Map<String, Object> map);

	public void scrap(Map<String, Object> map);

	public void deleteScrap(Map<String, Object> map);

}