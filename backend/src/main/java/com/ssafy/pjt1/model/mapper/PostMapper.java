package com.ssafy.pjt1.model.mapper;

import com.ssafy.pjt1.model.dto.post.PostDto;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostMapper {

	public void createPost(PostDto postDto);

	public PostDto getPostById(String post_id);

}