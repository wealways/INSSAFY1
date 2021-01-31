package com.ssafy.pjt1.model.service.checkList;

import java.util.List;

import com.ssafy.pjt1.model.dto.checkList.CheckListItemDto;

public interface CheckListItemService {
    public void createCheckLsit(CheckListItemDto item);

    public List<CheckListItemDto> selectCheckLsit(String board_id);

    public int updateCheckLsit(CheckListItemDto item);

    public int deleteCheckList(String check_list_item_id);
}
