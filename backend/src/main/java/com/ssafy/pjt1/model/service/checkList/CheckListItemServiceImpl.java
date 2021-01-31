package com.ssafy.pjt1.model.service.checkList;

import java.util.List;

import com.ssafy.pjt1.model.dto.checkList.CheckListItemDto;
import com.ssafy.pjt1.model.mapper.CheckListItemMapper;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckListItemServiceImpl implements CheckListItemService {
    @Autowired
    private SqlSession sqlSession;

    @Override
    public void createCheckLsit(CheckListItemDto item) {
        sqlSession.getMapper(CheckListItemMapper.class).createCheckLsit(item);
    }

    @Override
    public List<CheckListItemDto> selectCheckLsit(String board_id) {
        return sqlSession.getMapper(CheckListItemMapper.class).selectCheckLsit(board_id);
    }

    @Override
    public int updateCheckLsit(CheckListItemDto item) {
        return sqlSession.getMapper(CheckListItemMapper.class).updateCheckLsit(item);
    }

    @Override
    public int deleteCheckList(String check_list_item_id) {
        return sqlSession.getMapper(CheckListItemMapper.class).deleteCheckList(check_list_item_id);
    }

}