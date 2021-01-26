package com.ssafy.pjt1.model.dto.board;

public class BoardDto {
	private String board_id;
    private String board_name;
    private String board_description;
    private String board_image;
    private int board_igmyeong;
    private String board_location;
    private String board_hash;
    private String board_date;
    private String user_id;
    
	public String getBoard_id() {
		return board_id;
	}
	public void setBoard_id(String board_id) {
		this.board_id = board_id;
	}
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	public String getBoard_description() {
		return board_description;
	}
	public void setBoard_description(String board_description) {
		this.board_description = board_description;
	}
	public String getBoard_image() {
		return board_image;
	}
	public void setBoard_image(String board_image) {
		this.board_image = board_image;
	}
	public int getBoard_igmyeong() {
		return board_igmyeong;
	}
	public void setBoard_igmyeong(int board_igmyeong) {
		this.board_igmyeong = board_igmyeong;
	}
	public String getBoard_location() {
		return board_location;
	}
	public void setBoard_location(String board_location) {
		this.board_location = board_location;
	}
	public String getBoard_hash() {
		return board_hash;
	}
	public void setBoard_hash(String board_hash) {
		this.board_hash = board_hash;
	}
	public String getBoard_date() {
		return board_date;
	}
	public void setBoard_date(String board_date) {
		this.board_date = board_date;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public BoardDto(String board_id, String board_name, String board_description, String board_image,
			int board_igmyeong, String board_location, String board_hash, String board_date, String user_id) {
		super();
		this.board_id = board_id;
		this.board_name = board_name;
		this.board_description = board_description;
		this.board_image = board_image;
		this.board_igmyeong = board_igmyeong;
		this.board_location = board_location;
		this.board_hash = board_hash;
		this.board_date = board_date;
		this.user_id = user_id;
	}
	public BoardDto() {
		super();
	}
}
