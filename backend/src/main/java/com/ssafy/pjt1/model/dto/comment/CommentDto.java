package com.ssafy.pjt1.model.dto.comment;

public class CommentDto {
    private int comment_id;
    private int post_id;
    private String user_id;
    private String comment_description;
    private String comment_date;

    public int getComment_id() {
        return this.comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public int getPost_id() {
        return this.post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getComment_description() {
        return this.comment_description;
    }

    public void setComment_description(String comment_description) {
        this.comment_description = comment_description;
    }

    public String getComment_date() {
        return this.comment_date;
    }

    public void setComment_date(String comment_date) {
        this.comment_date = comment_date;
    }

    public CommentDto() {
        super();
    }
}