package com.ssafy.pjt1.model.dto.subscription;

public class SubscriptionDto {
    private int board_id;
    private String user_id;
    private int favorite_flag;
    private int write_post_count;
    private int user_role;

    public int getBoard_id() {
        return this.board_id;
    }

    public void setBoard_id(int board_id) {
        this.board_id = board_id;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getFavorite_flag() {
        return this.favorite_flag;
    }

    public void setFavorite_flag(int favorite_flag) {
        this.favorite_flag = favorite_flag;
    }

    public int getWrite_post_count() {
        return this.write_post_count;
    }

    public void setWrite_post_count(int write_post_count) {
        this.write_post_count = write_post_count;
    }

    public int getUser_role() {
        return this.user_role;
    }

    public void setUser_role(int user_role) {
        this.user_role = user_role;
    }

}