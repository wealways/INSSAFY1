package com.ssafy.pjt1.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.pjt1.model.dto.user.UserDto;
import com.ssafy.pjt1.model.service.JwtService;
import com.ssafy.pjt1.model.service.UserService;

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
@RequestMapping("/account")
public class UserController {
    public static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";
    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/confirm/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody UserDto userDto) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        logger.info("/confirm/login 잘 들어옴");
        try {
            UserDto loginUser = userService.login(userDto);
            logger.info("로그인 객체 : " + loginUser.getUser_email());
            if (loginUser != null) {
                String token = jwtService.create("userid", loginUser.getUser_email(), "access-token");// key, data,
                                                                                                      // subject
                logger.info("로그인 토큰정보 : {}", token);
                // 토큰 정보는 response의 헤더로 보내고 나머지는 Map에 담는다.
                resultMap.put("auth-token", token);
                resultMap.put("user-email", loginUser.getUser_email());
                resultMap.put("user-nickname", loginUser.getUser_nickname());
                resultMap.put("message", SUCCESS);
                status = HttpStatus.ACCEPTED;
            } else {
                logger.info("로그인 null");
                resultMap.put("message", FAIL);
                status = HttpStatus.ACCEPTED;
            }
        } catch (Exception e) {
            logger.error("로그인 실패 : {}", e);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    @PostMapping("/confirm/join")
    public ResponseEntity<Map<String, Object>> join(@RequestBody UserDto userDto, HttpServletResponse response,
            HttpSession session) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        try {
            userService.join(userDto);// 조인 서비스 호출
            resultMap.put("res", "1");
        } catch (Exception e) {

            resultMap.put("res", "0");
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }
}