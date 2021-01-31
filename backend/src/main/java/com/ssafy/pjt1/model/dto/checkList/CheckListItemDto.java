package com.ssafy.pjt1.model.dto.checkList;

public class CheckListItemDto {
    private int check_list_item_id;
    private int board_id;
    private boolean check_list_item_done;
    private String check_list_item_description;

    public int getCheck_list_item_id() {
        return this.check_list_item_id;
    }

    public void setCheck_list_item_id(int check_list_item_id) {
        this.check_list_item_id = check_list_item_id;
    }

    public int getBoard_id() {
        return this.board_id;
    }

    public void setBoard_id(int board_id) {
        this.board_id = board_id;
    }

    public boolean isCheck_list_item_done() {
        return this.check_list_item_done;
    }

    public void setCheck_list_item_done(boolean check_list_item_done) {
        this.check_list_item_done = check_list_item_done;
    }

    public String getCheck_list_item_description() {
        return this.check_list_item_description;
    }

    public void setCheck_list_item_description(String check_list_item_description) {
        this.check_list_item_description = check_list_item_description;
    }

}
