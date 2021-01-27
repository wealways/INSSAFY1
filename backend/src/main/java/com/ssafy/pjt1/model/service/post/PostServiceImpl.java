package com.ssafy.pjt1.model.service.post;

import com.ssafy.pjt1.model.dto.post.PostDto;
import com.ssafy.pjt1.model.mapper.PostMapper;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private SqlSession sqlSession;

	public static final Logger logger = LoggerFactory.getLogger(PostServiceImpl.class);

	@Override
	public void createPost(PostDto postDto) {
		sqlSession.getMapper(PostMapper.class).createPost(postDto);
	}

	@Override
	public PostDto getPostById(String post_id) {
		return sqlSession.getMapper(PostMapper.class).getPostById(post_id);
	}
}