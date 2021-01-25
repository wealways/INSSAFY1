package com.ssafy.pjt1.model.service;

import java.util.Map;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.ssafy.pjt1.controller.UserController;

@Service
public class MailSendService {
	
	public static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
    private JavaMailSenderImpl mailSender;

	int size;
    //인증키 생성
    private String getKey(int size) {
        this.size = size;
        return getAuthCode();
    }

    //인증코드 난수 발생
    private String getAuthCode() {
        Random random = new Random();
        StringBuffer buffer = new StringBuffer();
        int num = 0;

        while(buffer.length() < size) {
            num = random.nextInt(10);
            buffer.append(num);
        }

        return buffer.toString();
    }

    //인증메일 보내기
    public String sendAuthMail(String email) {
        //6자리 난수 인증번호 생성
        String authKey = getKey(6);

        MimeMessage mail = mailSender.createMimeMessage();
        String mailContent = "<h1>[이메일 인증]</h1><br><p>아래 링크를 클릭하시면 이메일 인증이 완료됩니다.</p>"
                            + "<a href='http://localhost:8000/acount/joinConfirm?email=" 
                            + email + "&authKey=" + authKey + "' target='_blenk'>이메일 인증 확인</a>";

        try {
            mail.setSubject("회원가입 이메일 인증 ", "utf-8");
            mail.setText(mailContent, "utf-8", "html");
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            mailSender.send(mail);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

          return authKey;
    }

    //임시비밀번호 메일 보내기
    public String sendPwMail(String email) {
    	StringBuffer temp = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
		    int rIndex = random.nextInt(3);
		    switch (rIndex) {
		    case 0:
		        // a-z
		        temp.append((char) ((int) (random.nextInt(26)) + 97));
		        break;
		    case 1:
		        // A-Z
		        temp.append((char) ((int) (random.nextInt(26)) + 65));
		        break;
		    case 2:
		        // 0-9
		        temp.append((random.nextInt(10)));
		        break;
		    }
		}
		String pw = temp.toString();

        MimeMessage mail = mailSender.createMimeMessage();
        String mailContent = "<h1>[임시 비밀번호 발급]</h1><br><p>임시 비밀번호 발급이 완료되었습니다.</p>"
                            + "<p>"+pw+"</p>"+
                            "<p> 로그인 후 비밀번호 변경해 주십시오.</p>";

        try {
            mail.setSubject("임시 비밀번호 발급", "utf-8");
            mail.setText(mailContent, "utf-8", "html");
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            mailSender.send(mail);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return pw;
    }
}

