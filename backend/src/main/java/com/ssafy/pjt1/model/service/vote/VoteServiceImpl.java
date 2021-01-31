package com.ssafy.pjt1.model.service.vote;

import com.ssafy.pjt1.model.dto.vote.VoteDto;
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


}
