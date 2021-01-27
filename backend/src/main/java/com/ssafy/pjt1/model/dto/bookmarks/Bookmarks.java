package com.ssafy.pjt1.model.dto.bookmarks;

public class Bookmarks {
    private int bookmark_id;
    private int post_id;
    private String user_id;

    public int getBookmark_id() {
        return this.bookmark_id;
    }

    public void setBookmark_id(int bookmark_id) {
        this.bookmark_id = bookmark_id;
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

}
