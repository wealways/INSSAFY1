package com.ssafy.pjt1.model.service.calendar;

import java.util.List;

import com.ssafy.pjt1.model.dto.calendar.CalendarItemDto;

public interface CalendarItemService {
    // 생성 insert
    public void createCalendar(CalendarItemDto item);

    // 리스트 출력 select
    public List<CalendarItemDto> readCalendar(String board_id);

    // 일정 수정
    public int updateCalendar(CalendarItemDto item);
    // 일정 삭제

    // 달력숨기기?
    // 모든일정 삭제?
}