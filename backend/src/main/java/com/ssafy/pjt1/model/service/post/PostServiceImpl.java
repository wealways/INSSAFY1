package com.ssafy.pjt1.model.service.post;

import java.util.List;
import java.util.Map;

import com.ssafy.pjt1.model.dto.comment.CommentDto;
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
	public PostDto getPostById(int post_id) {
		return sqlSession.getMapper(PostMapper.class).getPostById(post_id);
	}

	@Override
	public int postModify(PostDto postDto) {
		return sqlSession.getMapper(PostMapper.class).postModify(postDto);
	}

	@Override
	public int postDelete(int post_id) {
		return sqlSession.getMapper(PostMapper.class).postDelete(post_id);
	}

	@Override
	public int isScrapped(Map<String, Object> map) {
		return sqlSession.getMapper(PostMapper.class).isScrapped(map);
	}

	@Override
	public void scrap(Map<String, Object> map) {
		sqlSession.getMapper(PostMapper.class).scrap(map);
	}

	@Override
	public void deleteScrap(Map<String, Object> map) {
		sqlSession.getMapper(PostMapper.class).deleteScrap(map);
	}

	@Override
	public int isLiked(Map<String, Object> map) {
		return sqlSession.getMapper(PostMapper.class).isLiked(map);
	}

	@Override
	public void like(Map<String, Object> map) {
		sqlSession.getMapper(PostMapper.class).like(map);
	}

	@Override
	public void plusCount(int post_id) {
		sqlSession.getMapper(PostMapper.class).plusCount(post_id);
	}

	@Override
	public void unlike(Map<String, Object> map) {
		sqlSession.getMapper(PostMapper.class).unlike(map);
	}

	@Override
	public void minusCount(int post_id) {
		sqlSession.getMapper(PostMapper.class).minusCount(post_id);
	}

	@Override
	public int getLikeCount(int post_id) {
		return sqlSession.getMapper(PostMapper.class).getLikeCount(post_id);
	}

	@Override
	public List<CommentDto> getComment(int post_id) {
		return sqlSession.getMapper(PostMapper.class).getComment(post_id);
	}
}