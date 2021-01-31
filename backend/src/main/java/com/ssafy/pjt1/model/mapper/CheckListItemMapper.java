package com.ssafy.pjt1.model.mapper;

import java.util.List;

import com.ssafy.pjt1.model.dto.checkList.CheckListItemDto;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CheckListItemMapper {
    // craete
    public void createCheckLsit(CheckListItemDto item);

    // select
    public List<CheckListItemDto> selectCheckLsit(String board_id);

    // update
    public int updateCheckLsit(CheckListItemDto item);

    // delete
    public int deleteCheckList(String check_list_item_id);
}
