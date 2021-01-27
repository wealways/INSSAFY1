package com.ssafy.pjt1.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssafy.pjt1.model.dto.calendar.CalendarItemDto;
import com.ssafy.pjt1.model.service.calendar.CalendarItemService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/calendar")
public class CalendarItemController {
    public static final Logger logger = LoggerFactory.getLogger(CalendarItemController.class);
    private static final String SUCCESS = "SUCCESS";
    private static final String FAIL = "FAIL";

    @Autowired
    private CalendarItemService service;

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createCalendar(@RequestBody CalendarItemDto item) {
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

    @GetMapping("/read")
    public ResponseEntity<Map<String, Object>> readCalendar(@PathVariable String board_id) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        logger.info("/read 호출");
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
}