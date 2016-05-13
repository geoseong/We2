package com.we2.Login.controller;

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

import com.we2.spring.auth.AuthInfo;
import com.we2.spring.auth.AuthService;
import com.we2.spring.auth.IdPasswordNotMatchingException;

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

	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
			/*public String HomeController(Locale locale, Model model) {
				logger.info("Welcome home! The client locale is {}.", locale);
				
				Date date = new Date();
				DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
				
				String formattedDate = dateFormat.format(date);
				
				model.addAttribute("serverTime", formattedDate );
				
				return "home";
			}*/
			
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginget(LoginCommand loginCommand,
			@CookieValue(value = "REMEMBER", required = false) Cookie rememberCookie){
		if (rememberCookie != null) {
			loginCommand.setUserid(rememberCookie.getValue());
			loginCommand.setRememberUserid(true);
		}
		return "registration/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginpost(
			LoginCommand loginCommand, Errors errors, HttpSession session,
			HttpServletResponse response) {
		
		// �� ���� �ùٸ��� �˻�.
		new LoginCommandValidator().validate(loginCommand, errors);
		
		// �����.
		logger.info("ID : " + loginCommand.getUserid() + " , PWD : " + loginCommand.getPwd());
		System.out.println("ID : " + loginCommand.getUserid() + " , PWD : " + loginCommand.getPwd());
		
		if (errors.hasErrors()) {
			return "registration/login";
		}
		
		try {
			// �α��� Ŀ�ǵ�κ��� id, pwd�� �޾Ƽ� �����۾� ���ļ� ���ǿ� �Ѿ ������ ���ε���ü�� ���Ϲ���
			AuthInfo authInfo
				= authService.authenticate(loginCommand.getUserid(), loginCommand.getPwd());
					
			// ���ǿ����� ȸ������ �߰�.
			session.setAttribute("authInfo", authInfo);
			
			// ���� �ڵ��ϼ��� ���ϸ� ��Ű�� 30�ϵ��� userid�� ���̰� ��.
			Cookie rememberCookie = 
					new Cookie("REMEMBER", loginCommand.getUserid());
			rememberCookie.setPath("/");	// �ش� ��Ű�� �������
			
			if (loginCommand.isRememberUserid()) {
				rememberCookie.setMaxAge(60 * 60 * 24 * 30);	// 30�ϵ���.
			} else {
				rememberCookie.setMaxAge(0);
			}
			response.addCookie(rememberCookie);
			
			logger.info("ȸ�� " + authInfo.getUserid() + "�α�����.");
			
			return "index";
		} catch (IdPasswordNotMatchingException e) {
			errors.reject("idPasswordNotMatching");
			return "registration/login";
		} //end try-catch
	} //end loginpost()
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String joinForm(){
		return "registration/loginForm";
	}

	@RequestMapping(value = "/We2_join", method = RequestMethod.GET)
	public String joinForm2(){
		return "registration/We2_join";
	}
}
