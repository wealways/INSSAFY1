package com.ssafy.pjt1.model.dto.post;

public class PostDto {
    private int post_id;
    private String user_id;
    private int board_id;
    private String post_date;
    private String post_title;
    private String post_description;
    private int post_like;
    private String post_image;
    private String post_iframe;
    private String post_header;
    private int post_state;

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

    public int getBoard_id() {
        return this.board_id;
    }

    public void setBoard_id(int board_id) {
        this.board_id = board_id;
    }

    public String getPost_date() {
        return this.post_date;
    }

    public void setPost_date(String post_date) {
        this.post_date = post_date;
    }

    public String getPost_title() {
        return this.post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public String getPost_description() {
        return this.post_description;
    }

    public void setPost_description(String post_description) {
        this.post_description = post_description;
    }

    public int getPost_like() {
        return this.post_like;
    }

    public void setPost_like(int post_like) {
        this.post_like = post_like;
    }

    public String getPost_image() {
        return this.post_image;
    }

    public void setPost_image(String post_image) {
        this.post_image = post_image;
    }

    public String getPost_iframe() {
        return this.post_iframe;
    }

    public void setPost_iframe(String post_iframe) {
        this.post_iframe = post_iframe;
    }

    public String getPost_header() {
        return this.post_header;
    }

    public void setPost_header(String psot_header) {
        this.post_header = psot_header;
    }

    public int getPost_state() {
        return this.post_state;
    }

    public void setPost_state(int post_state) {
        this.post_state = post_state;
    }

    public PostDto() {
        super();
    }
}
