package com.ssafy.pjt1.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssafy.pjt1.model.dto.comment.CommentDto;
import com.ssafy.pjt1.model.dto.post.PostDto;
import com.ssafy.pjt1.model.dto.subscription.SubscriptionDto;
import com.ssafy.pjt1.model.dto.user.UserDto;
import com.ssafy.pjt1.model.service.JwtService;
import com.ssafy.pjt1.model.service.MailSendService;
import com.ssafy.pjt1.model.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
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

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/account")
public class UserController {
    public static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private static final String SUCCESS = "SUCCESS";
    private static final String FAIL = "FAIL";

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private MailSendService mss;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /*
     * 기능: 로그인
     * 
     * developer: 문진환
     * 
     * @param UserDto
     * 
     * @return ResultMap
     * 
     * time: 2021/01/23
     */
    @ApiOperation(value = "로그인", notes = "email, password를 입력해서 로그인 가능")
    @PostMapping("/confirm/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody UserDto userDto) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        logger.info("/confirm/login 호출 성공");
        try {
            UserDto loginUser = userService.login(userDto);
            logger.info("로그인 객체 : " + loginUser.getUser_email());
            if (loginUser != null
                    && passwordEncoder.matches(userDto.getUser_password(), loginUser.getUser_password())) {
                // 토큰 생성
                String token = jwtService.create("userid", loginUser.getUser_email(), "auth_token");
                logger.info("로그인 토큰정보 : {}", token);
                if (loginUser.getUser_auth() == 0) {// 메일 인증 안 받음
                    resultMap.put("message", "NO_AUTH");
                } else if (loginUser.getUser_auth() == 1) {// 메일 인증 안 받음
                    resultMap.put("message", SUCCESS);
                }
                resultMap.put("auth_token", token);
                resultMap.put("user", loginUser);
                status = HttpStatus.ACCEPTED;
            } else {
                logger.info("로그인 FAIL");
                resultMap.put("message", FAIL);
                status = HttpStatus.ACCEPTED;
            }
        } catch (Exception e) {
            resultMap.put("message", FAIL);
            logger.error("error", e);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    /*
     * 기능: 회원가입
     * 
     * developer: 윤수민
     * 
     * @param UserDto
     * 
     * @return ResultMap * time:
     */
    @ApiOperation(value = "회원가입", notes = "form 입력해서 회원가입")
    @PostMapping("/confirm/join")
    public ResponseEntity<Map<String, Object>> join(@RequestBody UserDto userDto) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        logger.info("/confirm/join 호출 성공");
        try {
            String id = userService.getId();
            logger.info(id);
            userDto.setUser_id(id);

            // 패스워드 암호화해서 저장
            String encoded_password = passwordEncoder.encode(userDto.getUser_password());
            userDto.setUser_password(encoded_password);
            userService.join(userDto);// 조인 서비스 호출
            // 임의의 authKey 생성 & 이메일 발송
            String authKey = mss.sendAuthMail(userDto.getUser_email());

            userDto.setUser_authKey(authKey);

            Map<String, String> map = new HashMap<String, String>();
            map.put("user_email", userDto.getUser_email());
            map.put("user_authKey", userDto.getUser_authKey());
            System.out.println(map);

            // DB에 authKey 업데이트
            userService.updateAuthKey(map);
            resultMap.put("message", SUCCESS);
        } catch (Exception e) {
            resultMap.put("message", FAIL);
            logger.error("error", e);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    /*
     * 기능: 이메일 중복체크
     * 
     * developer: 윤수민
     * 
     * @param
     * 
     * @return time:
     */
    @GetMapping("/confirm/emailCheck/{user_email}")
    public ResponseEntity<Map<String, Object>> emailCheck(@PathVariable String user_email) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        logger.info("comfirm/emailcheck 호출 성공");
        logger.info(user_email);
        try {
            int num = userService.emailCheck(user_email);
            logger.info("중복된 email 수: " + num);
            if (num == 0) {
                resultMap.put("message", SUCCESS);
                status = HttpStatus.ACCEPTED;
            } else {
                resultMap.put("message", FAIL);
                status = HttpStatus.NOT_ACCEPTABLE;
            }
        } catch (Exception e) {
            resultMap.put("message", FAIL);
            logger.error("error", e);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    /*
     * 기능: 메일에서 링크를 누른 경우 인증 페이지 이동
     * 
     * developer: 윤수민
     * 
     * @param:
     * 
     * @return:
     */
    @GetMapping("/confirm/joinConfirm")
    public String joinConfirm(@RequestParam Map<String, String> map) {
        userService.updateAuthStatus(map);
        logger.info("이메일 버튼 눌림");
        String msg = "이메일 인증이 완료되었습니다.";
        return msg;
    }

    /*
     * 기능: 패스워드 찾기, 임의의 토큰 값으로 패스워드 변경
     * 
     * developer: 윤수민
     * 
     * @param :
     * 
     * @return :
     */
    @PostMapping("/confirm/sendPwMail")
    public ResponseEntity<Map<String, Object>> sendPwMail(@RequestBody UserDto userDto) {
        String email = userDto.getUser_email();
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        logger.info("/confirm/sendPwEmail 호출 성공");
        try {
            String pw = mss.sendPwMail(email);
            Map<String, String> map = new HashMap<>();
            // 패스워드 암호화해서 저장
            String encoded_password = passwordEncoder.encode(pw);
            map.put("pw", encoded_password);
            map.put("email", email);
            userService.updatePw(map);
            resultMap.put("message", SUCCESS);
        } catch (Exception e) {
            resultMap.put("message", FAIL);
            logger.error("error", e);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    /*
     * 기능: 마이페이지
     * 
     * developer: 문진환
     * 
     * @param : user_email
     * 
     * @return ResultMap
     */
    @GetMapping("/user/{user_id}")
    public ResponseEntity<Map<String, Object>> userInfo(@PathVariable("user_id") String user_id) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        logger.info("/user/user_email 호출성공");
        try {
            UserDto userDto = userService.userInfo(user_id);
            if (userDto != null) {
                resultMap.put("user", userDto);
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
     * 기능: 내 정보 수정(이미지, 닉네임, 지역, 기수)
     * 
     * developer: 문진환
     * 
     * @param : user_img, user_nickname, user_location, user_generation
     * 
     * @return
     */
    @PutMapping("/user")
    public ResponseEntity<Map<String, Object>> userModify(@RequestBody UserDto userDto) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        logger.info("/modify 호출 성공");
        try {
            if (userService.userModify(userDto) == 1) {
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
     * 기능: 패스워드 변경시 기존 패스워드 한번더 체크
     * 
     * developer: 문진환
     * 
     * @param : 아이디, 비밀번호
     * 
     * @return :
     */
    @PostMapping("/user/password")
    public ResponseEntity<Map<String, Object>> passwordCheck(@RequestBody Map<String, String> map) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        try {
            UserDto encodedUser = userService.userInfo(map.get("user_id"));
            if (passwordEncoder.matches(map.get("user_password"), encodedUser.getUser_password())) {
                resultMap.put("message", SUCCESS);
            } else {
                resultMap.put("message", FAIL);
            }
        } catch (Exception e) {
            resultMap.put("message", FAIL);
            logger.error("error", e);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    /*
     * 기능: 패스워드 변경
     * 
     * developer: 문진환
     * 
     * @param : user_email, user_password
     * 
     * @return :
     */
    @PutMapping("/user/password")
    public ResponseEntity<Map<String, Object>> passwordModify(@RequestBody Map<String, String> map) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        logger.info("@put /user/password 호출 성공");
        try {
            // 패스워드 암호화해서 저장
            String encoded_password = passwordEncoder.encode(map.get("user_password"));
            map.put("pw", encoded_password);
            map.put("email", map.get("user_email"));
            userService.updatePw(map);
            resultMap.put("message", SUCCESS);
        } catch (Exception e) {
            resultMap.put("message", FAIL);
            logger.error("error", e);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    /*
     * 기능: 회원 탈퇴
     * 
     * developer: 문진환
     * 
     * @param : user_id7
     * 
     * @return : SUCCESS
     */
    @DeleteMapping("/user/{user_id}")
    public ResponseEntity<Map<String, Object>> userDelete(@PathVariable("user_id") String user_id) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        logger.info("@delte /user 호출성공");
        logger.info("user_id :" + user_id);
        try {
            if (userService.userDelete(user_id) == 1) {
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
     * 기능: 구독 보드(subscription) 리스트 출력
     * 
     * developer: 문진환
     * 
     * @param : user_id
     * 
     * @return : List<Subscription>
     */
    @GetMapping("user/getSubBoards/{user_id}")
    public ResponseEntity<Map<String, Object>> getSubBoards(@PathVariable String user_id) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        logger.info("user/getSubBoards/user_id 호출성공");
        try {
            List<SubscriptionDto> boards = userService.getSubBoards(user_id);
            resultMap.put("boards", boards);
            resultMap.put("message", SUCCESS);
        } catch (Exception e) {
            resultMap.put("message", FAIL);
            logger.error("error", e);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    /*
     * 기능: 댓글(comments) 가져오기
     * 
     * developer: 문진환
     * 
     * @param : user_id
     * 
     * @return : List<Comments>
     */
    @GetMapping("user/getComments/{user_id}")
    public ResponseEntity<Map<String, Object>> getComments(@PathVariable String user_id) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        logger.info("user/getComents/user_id 호출성공");
        try {
            resultMap.put("message", SUCCESS);
            List<CommentDto> comments = userService.getComments(user_id);
            resultMap.put("comments", comments);
        } catch (Exception e) {
            resultMap.put("message", FAIL);
            logger.error("error", e);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    /*
     * 기능: 작성글(post) 가져오기
     * 
     * developer: 문진환
     * 
     * @param : user_id
     * 
     * @return : List<Post>
     */
    @GetMapping("user/getPosts/{user_id}")
    public ResponseEntity<Map<String, Object>> getPost(@PathVariable String user_id) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        logger.info("user/getPosts/user_id 호출성공");
        try {
            resultMap.put("message", SUCCESS);
            List<PostDto> posts = userService.getPosts(user_id);
            logger.info("posts", posts);
            resultMap.put("posts", posts);
            status = HttpStatus.ACCEPTED;
        } catch (Exception e) {
            resultMap.put("message", FAIL);
            logger.error("error", e);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    /*
     * 기능: 북마크(BookMark) 가져오기
     * 
     * developer: 문진환
     * 
     * @param : user_id
     * 
     * @return : List<Post>
     */
    @GetMapping("user/getScraps/{user_id}")
    public ResponseEntity<Map<String, Object>> getScraps(@PathVariable String user_id) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        logger.info("user/getScraps/user_id 호출성공");
        try {
            resultMap.put("message", SUCCESS);
            List<PostDto> scraps = userService.getScraps(user_id);
            logger.info("scraps", scraps);
            resultMap.put("scraps", scraps);
            status = HttpStatus.ACCEPTED;
        } catch (Exception e) {
            resultMap.put("message", FAIL);
            logger.error("error", e);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }
}