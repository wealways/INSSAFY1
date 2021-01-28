package com.ssafy.pjt1.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssafy.pjt1.model.dto.calendar.CalendarItemDto;
import com.ssafy.pjt1.model.service.calendar.CalendarItemService;

import org.apache.ibatis.annotations.Delete;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/calendar")
public class CalendarItemController {
    public static final Logger logger = LoggerFactory.getLogger(CalendarItemController.class);
    private static final String SUCCESS = "SUCCESS";
    private static final String FAIL = "FAIL";

    @Autowired
    private CalendarItemService service;

    /*
     * 기능: 캘린더 item 생성
     * 
     * developer: 문진환
     * 
     * @param CalendarItemDto
     * 
     * @return success, fail
     */
    @ApiOperation(value = "캘린더 item 생성", notes = "아이템 생성하기")
    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createCalendar(
            @RequestBody @ApiParam(value = "calendar item의 정보를 DTO에 주입") CalendarItemDto item) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        logger.info("/create 호출");
        logger.info("form", item);
        try {
            service.createCalendar(item);
            resultMap.put("message", SUCCESS);
            status = HttpStatus.OK;
        } catch (Exception e) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            logger.error("error", e);
            resultMap.put("message", FAIL);
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    /*
     * 기능: 캘린더 아이템 리스트 출력
     * 
     * developer: 문진환
     * 
     * @param CalendarItemDto
     * 
     * @return 리스트
     */
    @ApiOperation(value = "캘린더 item 리스트 출력", notes = "board에 해당하는 모든 캘린더 item갖고 오기")
    @GetMapping("/read/{board_id}")
    public ResponseEntity<Map<String, Object>> readCalendar(
            @PathVariable @ApiParam(value = "보드 아이디 입력") String board_id) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        logger.info("/read 호출");
        logger.info("id: " + board_id);
        try {
            List<CalendarItemDto> items = service.readCalendar(board_id);
            resultMap.put("message", SUCCESS);
            resultMap.put("calendars", items);
            status = HttpStatus.OK;
        } catch (Exception e) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            logger.error("error", e);
            resultMap.put("message", FAIL);
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    /*
     * 기능: item 수정
     * 
     * developer: 문진환
     * 
     * @param UserDto
     * 
     * @return ResultMap * time:
     */
    @PutMapping("/update")
    public ResponseEntity<Map<String, Object>> updateCalendar(@RequestBody CalendarItemDto item) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        logger.info("/update 호출성공");
        try {
            int res = service.updateCalendar(item);
            if (res == 1) {
                resultMap.put("message", SUCCESS);
                status = HttpStatus.OK;
            } else {
                resultMap.put("message", FAIL);
                status = HttpStatus.NO_CONTENT;
            }
        } catch (Exception e) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            logger.error("error", e);
            resultMap.put("message", FAIL);
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    /*
     * 기능: 달력 item 삭제
     * 
     * developer: 문진환
     * 
     * @param UserDto
     * 
     * @return ResultMap * time:
     */
    @DeleteMapping("delete/{calendar_item_id}")
    public ResponseEntity<Map<String, Object>> deleteCalendars(@PathVariable String calendar_item_id) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        logger.info("/delete 호출");
        logger.info("calendar_item_id : {}", calendar_item_id);
        try {
            int res = service.deleteCalendar(calendar_item_id);
            if (res == 1) {
                resultMap.put("message", SUCCESS);
                status = HttpStatus.OK;
            } else {
                resultMap.put("message", FAIL);
                status = HttpStatus.NO_CONTENT;
            }
        } catch (Exception e) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            logger.error("error", e);
            resultMap.put("message", FAIL);
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }
}