package com.ssafy.pjt1.model.dto.vote;

public class VoteSelectDto {

    private String user_id;
    private int vote_item_id;

    public String getUser_id() {
        return this.user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getVote_item_id() {
        return this.vote_item_id;
    }

    public void setVote_item_id(int vote_item_id) {
        this.vote_item_id = vote_item_id;
    }

    public VoteSelectDto(){
        super();
    }
}
