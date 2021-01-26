package com.ssafy.pjt1.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.pjt1.model.dto.board.BoardDto;
import com.ssafy.pjt1.model.service.BoardService;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/board")
public class BoardController {
	
	public static final Logger logger = LoggerFactory.getLogger(UserController.class);
    
    @Autowired
    private BoardService boardService;

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> join(@RequestBody Map<String, Object> param) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        try {
        	BoardDto boardDto = new BoardDto();
        	boardDto.setBoard_name((String)param.get("board_name"));
        	boardDto.setBoard_description((String)param.get("board_description"));
        	boardDto.setBoard_image((String)param.get("board_image"));
        	boardDto.setBoard_igmyeong((int)param.get("board_igmyeong"));
        	boardDto.setBoard_location((String)param.get("board_location"));
        	boardDto.setBoard_hash((String)param.get("board_hash"));
        	boardDto.setUser_id((String)param.get("user_id"));
            boardService.createBoard(boardDto);
            
            Map<String, Object> map = new HashMap<>();
            map.put("user_id",boardDto.getUser_id());
            map.put("board_id",boardDto.getBoard_id());
            map.put("user_role",1);
            boardService.subscribe(map);

            Map<String, Object> map2 = new HashMap<>();
            map2.put("board_id",boardDto.getBoard_id());
            map2.put("checklist_flag",(int)param.get("checklist_flag"));
            map2.put("calendar_flag",(int)param.get("calendar_flag"));
            map2.put("vote_flag",(int)param.get("vote_flag"));
            boardService.addFunction(map2);
            
            resultMap.put("message", "SUCCESS");
        } catch (Exception e) {
            logger.error("실패", e);
            resultMap.put("message", "FAIL");
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }
    
    @PostMapping("/subscribe")
    public ResponseEntity<Map<String, Object>> subscribe(@RequestBody Map<String, Object> param) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        logger.info("board/subscribe");
        try {
        	Map<String, Object> map = new HashMap<>();
            map.put("user_id",(String)param.get("user_id"));
            map.put("board_id",(String)param.get("board_id"));
            map.put("user_role",(int)param.get("user_role"));
            logger.info("map:"+map);
            int count = boardService.isSubscribed(map);
            logger.info("count:"+count);
            if(count==0) {
            	logger.info("구독 설정");
            	boardService.subscribe(map);
            }else {
            	logger.info("구독 해지");
            	// 관리자 아닐 경우 구독 해지
            	boardService.unsubscribe(map);
            }
      
            resultMap.put("message", "SUCCESS");
        } catch (Exception e) {
            logger.error("실패", e);
            resultMap.put("message", "FAIL");
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }
    
}
