package com.ssafy.pjt1.model.service.vote;

import com.ssafy.pjt1.model.dto.vote.VoteDto;

public interface VoteService {

	public void createVote(VoteDto voteDto);

	public int voteModify(VoteDto voteDto);

	public int voteDelete(int vote_id);
    
}
