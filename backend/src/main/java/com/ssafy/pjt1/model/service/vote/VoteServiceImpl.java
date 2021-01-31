package com.ssafy.pjt1.model.service.vote;

import java.util.List;
import java.util.Map;

import com.ssafy.pjt1.model.dto.vote.VoteDto;
import com.ssafy.pjt1.model.dto.vote.VoteItemDto;
import com.ssafy.pjt1.model.dto.vote.VoteSelectDto;
import com.ssafy.pjt1.model.mapper.VoteMapper;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public void createVote(VoteDto voteDto) {
        sqlSession.getMapper(VoteMapper.class).createVote(voteDto);
    }

    @Override
    public int voteModify(VoteDto voteDto) {
        return sqlSession.getMapper(VoteMapper.class).voteModify(voteDto);
    }

    @Override
    public int voteDelete(int vote_id) {
        return sqlSession.getMapper(VoteMapper.class).voteDelete(vote_id);
    }

    @Override
    public void createVoteItem(VoteItemDto voteItemDto) {
        sqlSession.getMapper(VoteMapper.class).createVoteItem(voteItemDto);
    }

    @Override
    public int voteItemModify(VoteItemDto voteItemDto) {
        return sqlSession.getMapper(VoteMapper.class).voteItemModify(voteItemDto);
    }

    @Override
    public int voteItemDelete(int vote_item_id) {
        return sqlSession.getMapper(VoteMapper.class).voteItemDelete(vote_item_id);
    }

    @Override
    public void selectVote(VoteSelectDto voteSelectDto) {
        sqlSession.getMapper(VoteMapper.class).selectVote(voteSelectDto);
    }

    @Override
    public VoteDto getVoteById(int vote_id) {
        return sqlSession.getMapper(VoteMapper.class).getVoteById(vote_id);
    }

    @Override
    public List<Map<String, Object>> getVoteItem(int vote_id) {
        return sqlSession.getMapper(VoteMapper.class).getVoteItem(vote_id);
    }


}
