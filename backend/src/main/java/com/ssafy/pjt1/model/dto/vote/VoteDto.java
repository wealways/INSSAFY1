package com.ssafy.pjt1.model.dto.vote;

public class VoteDto {

    private int vote_id;
    private int board_id;
    private String vote_name;
    private int vote_done;
    private String vote_description;
    private String vote_end_datetime;
    private int vote_duplication;
    private int vote_igmyeong;

    public int getVote_id() {
        return this.vote_id;
    }

    public void setVote_id(int vote_id) {
        this.vote_id = vote_id;
    }

    public int getBoard_id() {
        return this.board_id;
    }

    public void setBoard_id(int board_id) {
        this.board_id = board_id;
    }

    public String getVote_name() {
        return this.vote_name;
    }

    public void setVote_name(String vote_name) {
        this.vote_name = vote_name;
    }

    public int getVote_done() {
        return this.vote_done;
    }

    public void setVote_done(int vote_done) {
        this.vote_done = vote_done;
    }

    public String getVote_description() {
        return this.vote_description;
    }

    public void setVote_description(String vote_description) {
        this.vote_description = vote_description;
    }

    public String getVote_end_datetime() {
        return this.vote_end_datetime;
    }

    public void setVote_end_datetime(String vote_end_datetime) {
        this.vote_end_datetime = vote_end_datetime;
    }

    public int getVote_duplication() {
        return this.vote_duplication;
    }

    public void setVote_duplication(int vote_duplication) {
        this.vote_duplication = vote_duplication;
    }

    public int getVote_igmyeong() {
        return this.vote_igmyeong;
    }

    public void setVote_igmyeong(int vote_igmyeong) {
        this.vote_igmyeong = vote_igmyeong;
    }

    public VoteDto(){
        super();
    }
}
