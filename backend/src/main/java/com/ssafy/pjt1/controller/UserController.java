package com.ssafy.pjt1.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    private PasswordEncoder passwordEncoder;

    /*
     * 기능: 로그인
     * 
     * 개발자: 문진환
     * 
     * @param UserDto
     * 
     * @return ResultMap
     */
    @PostMapping("/confirm/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody UserDto userDto) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        logger.info("/confirm/login 호출성공");
        try {
            UserDto loginUser = userService.login(userDto);
            logger.info("로그인 객체 : " + loginUser.getUser_email());
            if (loginUser != null) {
                String token = jwtService.create("userid", loginUser.getUser_email(), "access-token");// key, data,
                                                                                                      // subject
                logger.info("로그인 토큰정보 : {}", token);
                // 토큰 정보는 response의 헤더로 보내고 나머지는 Map에 담는다.
                resultMap.put("access-token", token);
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

    /*
     * 기능: 회원가입
     * 
     * 개발자: 김수민
     * 
     * @param UserDto
     * 
     * @return ResultMap
     */
    @PostMapping("/confirm/join")
    public ResponseEntity<Map<String, Object>> join(@RequestBody UserDto userDto, HttpServletResponse response,
            HttpSession session) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        try {
            // userService.join(userDto);// 조인 서비스 호출
            // String encode = passwordEncoder.encode(userDto.getUser_password());
            // resultMap.put("password", encode);
            // if (passwordEncoder.matches(userDto.getUser_password(), encode)) {
            // resultMap.put("res", "success");
            // } else {
            // resultMap.put("res", "fail");
            // }
        } catch (Exception e) {

            resultMap.put("res", "fail");
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    /*
     * 기능: 마이페이지
     * 
     * 개발자: 문진환
     * 
     * @param
     * 
     * @return ResultMap
     */
    @GetMapping("/userInfo/{user_email}")
    public ResponseEntity<Map<String, Object>> userInfo(@PathVariable("user_email") String user_email,
            HttpServletResponse response, HttpSession session, HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        logger.info("/userInfo/user_email 호출성공");
        logger.info("저장된 토큰: " + request.getHeader("access-token"));
        if (jwtService.isUsable(request.getHeader("access-token"))) {
            try {
                UserDto userDto = userService.userInfo(user_email);
                if (userDto != null) {
                    resultMap.put("userDto", userDto);
                    resultMap.put("message", SUCCESS);
                }
            } catch (Exception e) {
                resultMap.put("message", FAIL);
            }
        } else {
            logger.info("토큰 인증 실패");
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    // 내 정보 수정

    // 비번 변경

    // 회원 탈퇴
}