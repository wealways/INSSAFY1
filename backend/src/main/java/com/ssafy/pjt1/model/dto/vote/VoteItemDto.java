package com.ssafy.pjt1.model.dto.vote;

public class VoteItemDto {
    private int calendar_item_id;
    private int board_id;
    private String calendar_item_title;
    private String calendar_item_description;
    private String calendar_item_datetime_start;
    private String calendar_item_datetime_end;

    public int getCalendar_item_id() {
        return this.calendar_item_id;
    }

    public void setCalendar_item_id(int calendar_item_id) {
        this.calendar_item_id = calendar_item_id;
    }

    public int getBoard_id() {
        return this.board_id;
    }

    public void setBoard_id(int board_id) {
        this.board_id = board_id;
    }

    public String getCalendar_item_title() {
        return this.calendar_item_title;
    }

    public void setCalendar_item_title(String calendar_item_title) {
        this.calendar_item_title = calendar_item_title;
    }

    public String getCalendar_item_description() {
        return this.calendar_item_description;
    }

    public void setCalendar_item_description(String calendar_item_description) {
        this.calendar_item_description = calendar_item_description;
    }

    public String getCalendar_item_datetime_start() {
        return this.calendar_item_datetime_start;
    }

    public void setCalendar_item_datetime_start(String calendar_item_datetime_start) {
        this.calendar_item_datetime_start = calendar_item_datetime_start;
    }

    public String getCalendar_item_datetime_end() {
        return this.calendar_item_datetime_end;
    }

    public void setCalendar_item_datetime_end(String calendar_item_datetime_end) {
        this.calendar_item_datetime_end = calendar_item_datetime_end;
    }

}
