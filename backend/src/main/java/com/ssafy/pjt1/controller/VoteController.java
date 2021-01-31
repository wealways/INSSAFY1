package com.ssafy.pjt1.controller;

import java.util.HashMap;
import java.util.Map;

import com.ssafy.pjt1.model.dto.vote.VoteDto;
import com.ssafy.pjt1.model.dto.vote.VoteItemDto;
import com.ssafy.pjt1.model.service.vote.VoteService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/vote")
public class VoteController {
    
    public static final Logger logger = LoggerFactory.getLogger(VoteController.class);
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    @Autowired
    private VoteService voteService;

    /*
     * 기능: 투표 생성
     * 
     * developer: 윤수민
     * 
     * @param : board_id,vote_description,vote_duplication,vote_end_datetime,vote_igmyeong,vote_name
     * 
     * @return : message
     */
    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> voteCreate(@RequestBody Map<String, Object> param) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        logger.info("vote/create 호출성공");
        try {
            VoteDto voteDto = new VoteDto();
            voteDto.setBoard_id((int) param.get("board_id"));
            voteDto.setVote_description((String) param.get("vote_description"));
            voteDto.setVote_duplication((int) param.get("vote_duplication"));
            voteDto.setVote_end_datetime((String) param.get("vote_end_datetime"));
            voteDto.setVote_igmyeong((int) param.get("vote_igmyeong"));
            voteDto.setVote_name((String) param.get("vote_name"));
            voteService.createVote(voteDto);

            resultMap.put("message", SUCCESS);
        } catch (Exception e) {
            logger.error("실패", e);
            resultMap.put("message", FAIL);
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }
    
    /*
     * 기능: 투표 수정
     * 
     * developer: 윤수민
     * 
     * @param : VoteDto
     * 
     * @return : message
     */
    @PutMapping("/modify")
    public ResponseEntity<Map<String, Object>> voteModify(@RequestBody VoteDto voteDto) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        logger.info("vote/modify 호출 성공");
        try {
            if (voteService.voteModify(voteDto) == 1) {
                resultMap.put("message", SUCCESS);
            }
        } catch (Exception e) {
            resultMap.put("message", FAIL);
            logger.error("error", e);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    /*
     * 기능: 투표 삭제
     * 
     * developer: 윤수민
     * 
     * @param : vote_id
     * 
     * @return : message
     */
    @DeleteMapping("/delete/{vote_id}")
    public ResponseEntity<Map<String, Object>> voteDelete(@PathVariable("vote_id") int vote_id) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        logger.info("vote/delete 호출성공");
        try {
            if (voteService.voteDelete(vote_id) == 1) {
                resultMap.put("message", SUCCESS);
            }
        } catch (Exception e) {
            resultMap.put("message", FAIL);
            logger.error("error", e);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

     /*
     * 기능: 투표 항목 생성
     * 
     * developer: 윤수민
     * 
     * @param : vote_id,vote_item_name
     * 
     * @return : message
     */
    @PostMapping("/item/create")
    public ResponseEntity<Map<String, Object>> voteItemCreate(@RequestBody Map<String, Object> param) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        logger.info("vote/item/create 호출성공");
        try {
            VoteItemDto voteItemDto = new VoteItemDto();
            voteItemDto.setVote_id((int) param.get("vote_id"));
            voteItemDto.setVote_item_name((String) param.get("vote_item_name"));
            voteService.createVoteItem(voteItemDto);

            resultMap.put("message", SUCCESS);
        } catch (Exception e) {
            logger.error("실패", e);
            resultMap.put("message", FAIL);
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

}
