package com.ssafy.pjt1.controller;

import java.util.HashMap;
import java.util.Map;

import com.ssafy.pjt1.model.dto.post.PostDto;
import com.ssafy.pjt1.model.service.post.PostService;

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

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/post")
public class PostController {

    public static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    @Autowired
    private PostService postService;

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
}