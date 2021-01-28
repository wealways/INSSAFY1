package com.ssafy.pjt1.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssafy.pjt1.model.dto.comment.CommentDto;
import com.ssafy.pjt1.model.dto.post.PostDto;
import com.ssafy.pjt1.model.service.post.PostService;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/post")
public class PostController {

    public static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    @Autowired
    private PostService postService;

    /*
     * 기능: 보드 내 포스트 작성
     * 
     * developer: 윤수민
     * 
     * @param : user_id, board_id, post_title, post_description, post_image, post_iframe, post_header, post_state
     * 
     * @return : message
     */
    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> join(@RequestBody Map<String, Object> param) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        logger.info("post/create 호출성공");
        try {
            PostDto postDto = new PostDto();
            postDto.setUser_id((String) param.get("user_id"));
            postDto.setBoard_id((int) param.get("board_id"));
            postDto.setPost_title((String) param.get("post_title"));
            postDto.setPost_description((String) param.get("post_description"));
            postDto.setPost_image((String) param.get("post_image"));
            postDto.setPost_iframe((String) param.get("post_iframe"));
            postDto.setPost_header((String) param.get("post_header"));
            postDto.setPost_state((int) param.get("post_state"));
            postService.createPost(postDto);

            resultMap.put("message", SUCCESS);
        } catch (Exception e) {
            logger.error("실패", e);
            resultMap.put("message", FAIL);
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    /*
     * 기능: 포스트 디테일
     * 
     * developer: 윤수민
     * 
     * @param : login_id, post_id
     * 
     * @return : message, PostDto, isScrapped, isLiked, like_count, commentList
     */
    @GetMapping("/getPostById")
    public ResponseEntity<Map<String, Object>> getPostById(@RequestParam(value = "post_id")int post_id, 
    @RequestParam(value = "login_id")String login_id){
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        logger.info("post/getPostById 호출성공");
        try {
            PostDto postDto = postService.getPostById(post_id);
            Map<String, Object> map = new HashMap<>();
            map.put("user_id", login_id);
            map.put("post_id", post_id);
            int isScrapped = postService.isScrapped(map);
            int isLiked = postService.isLiked(map);
            int like_count = postService.getLikeCount(post_id);
            List<CommentDto> commentList = postService.getComment(post_id);
            
            resultMap.put("postDto", postDto);
            resultMap.put("isScrapped", isScrapped);
            resultMap.put("isLiked", isLiked);   
            resultMap.put("like_count", like_count);   
            resultMap.put("commentList", commentList);          
            resultMap.put("message", SUCCESS);
        } catch (Exception e) {
            logger.error("실패", e);
            resultMap.put("message", FAIL);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    /*
     * 기능: 포스트 수정
     * 
     * developer: 윤수민
     * 
     * @param : PostDto
     * 
     * @return : message
     */
    @PutMapping("/modify")
    public ResponseEntity<Map<String, Object>> userModify(@RequestBody PostDto postDto) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        logger.info("post/modify 호출 성공");
        try {
            if (postService.postModify(postDto) == 1) {
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
     * 기능: 포스트 삭제
     * 
     * developer: 윤수민
     * 
     * @param : post_id
     * 
     * @return : message
     */
    @DeleteMapping("/delete/{post_id}")
    public ResponseEntity<Map<String, Object>> userDelete(@PathVariable("post_id") int post_id) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        logger.info("post/delete 호출성공");
        try {
            if (postService.postDelete(post_id) == 1) {
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
     * 기능: 포스트 스크랩
     * 
     * developer: 윤수민
     * 
     * @param : post_id, user_id
     * 
     * @return : message
     */
    @PostMapping("/scrap")
    public ResponseEntity<Map<String, Object>> scrap(@RequestBody Map<String, Object> param) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        logger.info("post/scrap 호출성공");
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("user_id", (String) param.get("user_id"));
            map.put("post_id", (int) param.get("post_id"));

            int count = postService.isScrapped(map);
            if (count == 0) {
                logger.info("스크랩 추가");
                postService.scrap(map);
            } else {
                logger.info("스크랩 삭제");
                postService.deleteScrap(map);
            }

            resultMap.put("message", SUCCESS);
        } catch (Exception e) {
            logger.error("실패", e);
            resultMap.put("message", FAIL);
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    /*
     * 기능: 포스트 좋아요
     * 
     * developer: 윤수민
     * 
     * @param : post_id, user_id
     * 
     * @return : message
     */
    @PostMapping("/like")
    public ResponseEntity<Map<String, Object>> likePost(@RequestBody Map<String, Object> param) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        logger.info("post/like 호출성공");
        try {
            Map<String, Object> map = new HashMap<>();
            String user_id = (String) param.get("user_id");
            int post_id = (int) param.get("post_id"); 
            map.put("user_id", user_id);
            map.put("post_id",post_id);
            logger.info("map: "+map);
            int count = postService.isLiked(map);
            if (count == 0) {
                logger.info("좋아요 클릭");
                postService.like(map);
                postService.plusCount(post_id);
            } else {
                logger.info("좋아요 삭제");
                postService.unlike(map);
                postService.minusCount(post_id);
            }

            resultMap.put("message", SUCCESS);
        } catch (Exception e) {
            logger.error("실패", e);
            resultMap.put("message", FAIL);
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }
}