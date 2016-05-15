package com.we2.login.controller;

import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.we2.spring.AuthInfo;
import com.we2.spring.AuthService;
import com.we2.spring.IdPasswordNotMatchingException;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")
public class LoginController {
	
	private AuthService authService;
	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String index(Locale locale) {
		logger.info("Welcome home! The client locale is {}.", locale);
		return "index";
	}

	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginget(LoginCommand loginCommand,
			@CookieValue(value = "REMEMBER", required = false) Cookie rememberCookie){
		if (rememberCookie != null) {
			loginCommand.setUserId(rememberCookie.getValue());
			loginCommand.setRememberUserid(true);
		}
		return "registration/Member_Login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginpost(
			LoginCommand loginCommand, Errors errors, HttpSession session,
			HttpServletResponse response) {
		
		// 폼 값이 올바른지 검사.
		new LoginCommandValidator().validate(loginCommand, errors);
		
		// 디버깅.
		logger.info("ID : " + loginCommand.getUserId() + " , PWD : " + loginCommand.getPwd());
		System.out.println("ID : " + loginCommand.getUserId() + " , PWD : " + loginCommand.getPwd());
		
		if (errors.hasErrors()) {
			return "registration/Member_Login";
		}
		
		try {
			// 로그인 커맨드로부터 id, pwd를 받아서 인증작업 거쳐서 세션에 넘어갈 변수들 바인딩객체를 리턴받음
				System.out.println("authinfo 정의하기 전");
			AuthInfo authInfo
				= authService.authenticate(loginCommand.getUserId(), loginCommand.getPwd());
			
			// 세션영역에 회원정보 추가
			session.setAttribute("authInfo", authInfo);
			
			// Cookie : 폼에 자동완성을 원하면 쿠키에 30일동안 userid를 보이게 함.
			Cookie rememberCookie = 
					new Cookie("REMEMBER", loginCommand.getUserId());
			rememberCookie.setPath("/");	// 해당 쿠키의 적용범위
			
				if (loginCommand.isRememberUserid()) {
					rememberCookie.setMaxAge(60 * 60 * 24 * 30);	// 30일동안.
				} else {
					rememberCookie.setMaxAge(0);
				}
				response.addCookie(rememberCookie);
				
				logger.info("회원 " + authInfo.getUserId() + "로그인함.");
				
				return "index";
		} catch (IdPasswordNotMatchingException e) {
			errors.reject("idPasswordNotMatching");
			return "registration/Member_Login";
		} //end try-catch
	} //end login.POST
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String joinForm(){
		return "registration/Member_Aggrement";
	}

	@RequestMapping(value = "/We2_join", method = RequestMethod.GET)
	public String joinForm2(){
		return "registration/Member_Join";
	}
}