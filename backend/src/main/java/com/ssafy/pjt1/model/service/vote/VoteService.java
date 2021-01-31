package com.ssafy.pjt1.model.service.vote;

import com.ssafy.pjt1.model.dto.vote.VoteDto;
import com.ssafy.pjt1.model.dto.vote.VoteItemDto;

public interface VoteService {

	public void createVote(VoteDto voteDto);

	public int voteModify(VoteDto voteDto);

	public int voteDelete(int vote_id);

	public void createVoteItem(VoteItemDto voteItemDto);
    
}
