package com.ssafy.pjt1.model.mapper;

import java.util.List;

import com.ssafy.pjt1.model.dto.calendar.CalendarItemDto;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CalendarItemMapper {
    public void createCalendar(CalendarItemDto item);

    public List<CalendarItemDto> readCalendar(String board_id);

    public int updateCalendar(CalendarItemDto item);
}
