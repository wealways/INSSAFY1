package com.ssafy.pjt1.model.service.calendar;

import java.util.List;

import com.ssafy.pjt1.model.dto.calendar.CalendarItemDto;
import com.ssafy.pjt1.model.mapper.CalendarItemMapper;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalendarItemServiceImpl implements CalendarItemService {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public void createCalendar(CalendarItemDto item) {
        sqlSession.getMapper(CalendarItemMapper.class).createCalendar(item);
    }

    @Override
    public List<CalendarItemDto> readCalendar(String board_id) {
        return sqlSession.getMapper(CalendarItemMapper.class).readCalendar(board_id);
    }

    @Override
    public int updateCalendar(CalendarItemDto item) {
        return sqlSession.getMapper(CalendarItemMapper.class).updateCalendar(item);
    }

}
