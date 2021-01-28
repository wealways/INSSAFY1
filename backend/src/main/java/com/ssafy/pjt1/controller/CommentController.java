package com.ssafy.pjt1.controller;

import java.util.HashMap;
import java.util.Map;

import com.ssafy.pjt1.model.dto.comment.CommentDto;
import com.ssafy.pjt1.model.service.comment.CommentService;

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
@RequestMapping("/comment")
public class CommentController {

    public static final Logger logger = LoggerFactory.getLogger(CommentController.class);
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    @Autowired
    private CommentService commentService;

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> create(@RequestBody Map<String, Object> param) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        logger.info("comment/create 호출성공");
        try {
            CommentDto commentDto = new CommentDto();
            commentDto.setUser_id((String) param.get("user_id"));
            commentDto.setPost_id((int) param.get("post_id"));
            commentDto.setComment_description((String) param.get("comment_description"));
            commentService.createComment(commentDto);

            int comment_id = commentDto.getComment_id();
            commentService.createNotification(comment_id);

            resultMap.put("message", SUCCESS);
        } catch (Exception e) {
            logger.error("실패", e);
            resultMap.put("message", FAIL);
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    @PutMapping("/modify")
    public ResponseEntity<Map<String, Object>> userModify(@RequestBody CommentDto commentDto) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        logger.info("comment/modify 호출 성공");
        try {
            if (commentService.commentModify(commentDto) == 1) {
                resultMap.put("message", SUCCESS);
            }
        } catch (Exception e) {
            resultMap.put("message", FAIL);
            logger.error("error", e);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    @DeleteMapping("/delete/{comment_id}")
    public ResponseEntity<Map<String, Object>> userDelete(@PathVariable("comment_id") int comment_id) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        logger.info("comment/delete 호출성공");
        try {
            if (commentService.commentDelete(comment_id) == 1) {
                resultMap.put("message", SUCCESS);
            }
        } catch (Exception e) {
            resultMap.put("message", FAIL);
            logger.error("error", e);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    // @GetMapping("/getPostById/{post_id}")
    // public ResponseEntity<Map<String, Object>> getPostById(@PathVariable("post_id") String post_id){
    //     Map<String, Object> resultMap = new HashMap<>();
    //     HttpStatus status = HttpStatus.ACCEPTED;
    //     logger.info("post/getPostById/{post_id} 호출성공");
    //     try {
    //         PostDto postDto = postService.getPostById(post_id);
    //         resultMap.put("post", postDto);
    //         resultMap.put("message", SUCCESS);
    //     } catch (Exception e) {
    //         logger.error("실패", e);
    //         resultMap.put("message", FAIL);
    //         status = HttpStatus.INTERNAL_SERVER_ERROR;
    //     }
    //     return new ResponseEntity<Map<String, Object>>(resultMap, status);
    // }

    // @PostMapping("/scrap")
    // public ResponseEntity<Map<String, Object>> scrap(@RequestBody Map<String, Object> param) {
    //     Map<String, Object> resultMap = new HashMap<>();
    //     HttpStatus status = HttpStatus.ACCEPTED;
    //     logger.info("post/scrap 호출성공");
    //     try {
    //         Map<String, Object> map = new HashMap<>();
    //         map.put("user_id", (String) param.get("user_id"));
    //         map.put("post_id", (int) param.get("post_id"));

    //         int count = postService.isScrapped(map);
    //         if (count == 0) {
    //             logger.info("스크랩 추가");
    //             postService.scrap(map);
    //         } else {
    //             logger.info("스크랩 삭제");
    //             postService.deleteScrap(map);
    //         }

    //         resultMap.put("message", SUCCESS);
    //     } catch (Exception e) {
    //         logger.error("실패", e);
    //         resultMap.put("message", FAIL);
    //     }
    //     return new ResponseEntity<Map<String, Object>>(resultMap, status);
    // }

    // @PostMapping("/like")
    // public ResponseEntity<Map<String, Object>> likePost(@RequestBody Map<String, Object> param) {
    //     Map<String, Object> resultMap = new HashMap<>();
    //     HttpStatus status = HttpStatus.ACCEPTED;
    //     logger.info("post/like 호출성공");
    //     try {
    //         Map<String, Object> map = new HashMap<>();
    //         String user_id = (String) param.get("user_id");
    //         int post_id = (int) param.get("post_id"); 
    //         map.put("user_id", user_id);
    //         map.put("post_id",post_id);
    //         logger.info("map: "+map);
    //         int count = postService.isLiked(map);
    //         logger.info("count: "+count);
    //         if (count == 0) {
    //             logger.info("좋아요 클릭");
    //             postService.like(map);
    //             postService.plusCount(post_id);
    //         } else {
    //             logger.info("좋아요 삭제");
    //             postService.unlike(map);
    //             postService.minusCount(post_id);
    //         }

    //         resultMap.put("message", SUCCESS);
    //     } catch (Exception e) {
    //         logger.error("실패", e);
    //         resultMap.put("message", FAIL);
    //     }
    //     return new ResponseEntity<Map<String, Object>>(resultMap, status);
    // }
}