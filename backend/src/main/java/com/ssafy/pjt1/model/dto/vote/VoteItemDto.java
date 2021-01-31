package com.ssafy.pjt1.model.dto.vote;

public class VoteItemDto {
    private int vote_item_id;
    private int vote_id;
    private String vote_item_name;

    public int getVote_item_id() {
        return this.vote_item_id;
    }

    public void setVote_item_id(int vote_item_id) {
        this.vote_item_id = vote_item_id;
    }

    public int getVote_id() {
        return this.vote_id;
    }

    public void setVote_id(int vote_id) {
        this.vote_id = vote_id;
    }

    public String getVote_item_name() {
        return this.vote_item_name;
    }

    public void setVote_item_name(String vote_item_name) {
        this.vote_item_name = vote_item_name;
    }
    
    public VoteItemDto(){
        super();
    }

}
