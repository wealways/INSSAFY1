package com.ssafy.pjt1.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.pjt1.model.dto.board.BoardDto;
import com.ssafy.pjt1.model.dto.subscription.Subscription;
import com.ssafy.pjt1.model.dto.user.UserDto;
import com.ssafy.pjt1.model.service.BoardService;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/board")
public class BoardController {

    public static final Logger logger = LoggerFactory.getLogger(BoardController.class);
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    @Autowired
    private BoardService boardService;

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> join(@RequestBody Map<String, Object> param) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        logger.info("board/create 호출성공");
        try {
            BoardDto boardDto = new BoardDto();
            boardDto.setBoard_name((String) param.get("board_name"));
            boardDto.setBoard_description((String) param.get("board_description"));
            boardDto.setBoard_image((String) param.get("board_image"));
            boardDto.setBoard_igmyeong((int) param.get("board_igmyeong"));
            boardDto.setBoard_location((String) param.get("board_location"));
            boardDto.setBoard_hash((String) param.get("board_hash"));
            boardDto.setUser_id((String) param.get("user_id"));
            boardService.createBoard(boardDto);

            Map<String, Object> map = new HashMap<>();
            map.put("user_id", boardDto.getUser_id());
            map.put("board_id", boardDto.getBoard_id());
            map.put("user_role", 1);
            boardService.subscribe(map);

            Map<String, Object> map2 = new HashMap<>();
            map2.put("board_id", boardDto.getBoard_id());
            map2.put("checklist_flag", (int) param.get("checklist_flag"));
            map2.put("calendar_flag", (int) param.get("calendar_flag"));
            map2.put("vote_flag", (int) param.get("vote_flag"));
            boardService.addFunction(map2);

            resultMap.put("message", SUCCESS);
        } catch (Exception e) {
            logger.error("실패", e);
            resultMap.put("message", FAIL);
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    @PostMapping("/subscribe")
    public ResponseEntity<Map<String, Object>> subscribe(@RequestBody Map<String, Object> param) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        logger.info("board/subscribe 호출성공");
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("user_id", (String) param.get("user_id"));
            map.put("board_id", (String) param.get("board_id"));
            map.put("user_role", (int) param.get("user_role"));
            logger.info("map:" + map);
            int count = boardService.isSubscribed(map);
            logger.info("count:" + count);
            if (count == 0) {
                logger.info("구독 설정");
                boardService.subscribe(map);
            } else {
                logger.info("구독 해지");
                // 관리자 아닐 경우 구독 해지
                boardService.unsubscribe(map);
            }

            resultMap.put("message", SUCCESS);
        } catch (Exception e) {
            logger.error("실패", e);
            resultMap.put("message", FAIL);
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    @GetMapping("/searchUser/{keyword}")
    public ResponseEntity<Map<String, Object>> searchUser(@PathVariable("keyword") String keyword) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        logger.info("board/searchUser 호출성공");
        try {
            resultMap.put("message", SUCCESS);
            List<UserDto> userList = boardService.searchUser(keyword);
            resultMap.put("userList", userList);
            
        } catch (Exception e) {
            resultMap.put("message", FAIL);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    @PostMapping("/updateManager")
    public ResponseEntity<Map<String, Object>> updateManager(@RequestBody Map<String, Object> param){
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        logger.info("board/updateManager 호출성공");
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("user_id", (String) param.get("user_id"));
            map.put("board_id", (String) param.get("board_id"));
            int count = boardService.isSubscribed(map);
            if (count == 0) {
                logger.info("구독 설정 + 관리자 추가");
                map.put("user_role",1);
                boardService.subscribe(map);
            } else {
                logger.info("관리자 추가");
                boardService.updateManager(map);
            }

            resultMap.put("message", SUCCESS);
        } catch (Exception e) {
            logger.error("실패", e);
            resultMap.put("message", FAIL);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    @PutMapping("/modify")
    public ResponseEntity<Map<String, Object>> modifyBoard(@RequestBody BoardDto boardDto) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        logger.info("/modify 호출 성공");
        try {
            if (boardService.modifyBoard(boardDto) == 1) {
                resultMap.put("message", SUCCESS);
            }else{
                resultMap.put("message", FAIL);
            }
        } catch (Exception e) {
            resultMap.put("message", FAIL);
            logger.error("수정 실패", e);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    @GetMapping("/getBoards")
    public ResponseEntity<Map<String, Object>> getBoards(@RequestParam(value = "sort")String sort){
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        logger.info("/board/getBoards 호출 성공");

        try {
            List<BoardDto> boardList;
            if(sort.equals("new")){
                logger.info("최신순 전체 보드 검색");
                boardList = boardService.getBoardsNew();
            }else{
                logger.info("구독순 전체 보드 검색");
                boardList = boardService.getBoardsPopular();
            }
            resultMap.put("boardList",boardList);
            resultMap.put("message", SUCCESS);
        } catch (Exception e) {
            resultMap.put("message", FAIL);
            logger.error("목록 호출 실패", e);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    @GetMapping("/searchBoard")
    public ResponseEntity<Map<String, Object>> searchBoard(@RequestParam(value = "sort")String sort, 
    @RequestParam(value = "keyword")String keyword){
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        logger.info("/board/searchBoard 호출 성공");
        try {
            List<BoardDto> boardList;
            if(sort.equals("new")){
                logger.info("최신순 보드 검색");
                boardList = boardService.searchBoardNew(keyword);
            }else{
                logger.info("구독순 보드 검색");
                boardList = boardService.searchBoardPopular(keyword);
            }
            resultMap.put("boardList",boardList);
            resultMap.put("message", SUCCESS);
        } catch (Exception e) {
            resultMap.put("message", FAIL);
            logger.error("검색 호출 실패", e);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

}