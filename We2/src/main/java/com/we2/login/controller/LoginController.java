package com.we2.login.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.we2.spring.AuthInfo;
import com.we2.spring.AuthService;
import com.we2.spring.IdPasswordNotMatchingException;
import com.we2.spring.Member;
import com.we2.spring.MemberDao;
import com.we2.spring.PjtJoinVO;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")
public class LoginController {
	@Autowired
	private AuthService authService;

	/*
	 * public void setAuthService(AuthService authService) { this.authService =
	 * authService; }
	 */
	@Autowired
	private MemberDao memberDao;
	/*
	 * public void setMemberDao(MemberDao memberDao) { this.memberDao =
	 * memberDao; }
	 */
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	private static final int String = 0;

	@RequestMapping(method = RequestMethod.GET)
	public String index(Locale locale, HttpServletRequest request, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginget(HttpServletRequest request, LoginCommand loginCommand,
			@RequestParam(value = "pjtadd", defaultValue = "false") String pjtadd, Model model,
			@CookieValue(value = "REMEMBER", required = false) Cookie rememberCookie) {
		if (rememberCookie != null) {
			loginCommand.setUserId(rememberCookie.getValue());
			loginCommand.setRememberUserid(true);
		}
		if (pjtadd.equals("yes")) {
			model.addAttribute("pjtadd", "yes");
		} else {
			pjtadd = "";
		}
		return "registration/Member_Login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginpost(LoginCommand loginCommand, Errors errors, HttpSession session, HttpServletResponse response,
			String pjtadd) {
		
		// 폼 값이 올바른지 검사.
		new LoginCommandValidator().validate(loginCommand, errors);

		// 디버깅.
		logger.info("ID : " + loginCommand.getUserId() + " , PWD : " + loginCommand.getPwd());

		if (errors.hasErrors()) {
			return "registration/Member_Login";
		}

		try {
			// 로그인 커맨드로부터 id, pwd를 받아서 인증작업 거쳐서 세션에 넘어갈 변수들 바인딩객체를 리턴받음
			AuthInfo authInfo = authService.authenticate(loginCommand.getUserId(), loginCommand.getPwd());

			// 세션영역에 회원정보 추가
			session.setAttribute("authInfo", authInfo);

			// 폼에 자동완성을 원하면 쿠키에 30일동안 userid를 보이게 함.
			Cookie rememberCookie = new Cookie("REMEMBER", loginCommand.getUserId());
			rememberCookie.setPath("/"); // 해당 쿠키의 적용범위

			if (loginCommand.isRememberUserid()) {
				rememberCookie.setMaxAge(60 * 60 * 24 * 30); // 30일동안.
			} else {
				rememberCookie.setMaxAge(0);
			}
			response.addCookie(rememberCookie);

			logger.info("회원 " + authInfo.getUserId() + "로그인함.");

			if (pjtadd.equals("yes")) {
				pjtadd = null;
				return "redirect:/project/addpjtmember";
			}

			return "/index";
		} catch (IdPasswordNotMatchingException e) {
			errors.rejectValue("userId", "idpwdNotMatching");
			return "registration/Member_Login";
		} // end try-catch
	} // end loginpost()

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String member_Aggrement() {
		return "registration/Member_Aggrement";
	}

	@RequestMapping(value = "/Member_Aggrement", method = RequestMethod.POST)
	public String member_Form(Member member) {
		return "registration/Member_Join";
	}

	@RequestMapping(value = "/We2_idCheck")
	public String doGet(@RequestParam("userId") String userId, Model model) {

		// int result = mDao.confirmID(userId);
		int result = authService.idCheck(userId);

		model.addAttribute("userId", userId);
		model.addAttribute("result", result);

		return "registration/We2_idCheck";
	}

	@RequestMapping(value = "/Member_Join", method = RequestMethod.POST)
	public String member_join(Member member, Errors errors) {
		memberDao.insert(member);
		return "/index";
	}

	@RequestMapping(value = "/Member_Mypage", method = RequestMethod.GET)
	public String aopMember_MypageView(HttpServletRequest request, AuthInfo authInfo, Model model) {

		HttpSession session = request.getSession(); // 세션영역을 가져옴

		authInfo = (AuthInfo) session.getAttribute("authInfo");

		String userId = authInfo.getUserId();

		AuthInfo mVo = (AuthInfo) session.getAttribute("authInfo");
		//mVo 세션에서 가져오지 마시고, 세션정보의 userid로 db를 새로 조회해와서 모델

		List<PjtJoinVO> list = memberDao.selectAll(userId);
		model.addAttribute("pjtlist", list);

		// 세션에서 authInfo값을 가져옴
		// mVo에 모든 값이 들어가져 있고 성만 값을 가져옴!
		model.addAttribute("mVo", mVo);
		return "registration/Member_MypageView";
	}

	/** 회원정보 수정완료 */
	@RequestMapping(value = "/Member_Mypage", method = RequestMethod.POST)
	public String Member_MypageViewpost(HttpServletRequest request) {
		
			String name = request.getParameter("name");
			String userId =request.getParameter("userId");
			String pwd =request.getParameter("pwd");
			String pwd_confirm =request.getParameter("pwd_confirm");
			String phone =request.getParameter("phone");
			String email = request.getParameter("email");
			String gender =request.getParameter("gender");
			String RegDate= request.getParameter("regDate");
			
			memberDao.update(name, userId, pwd, pwd_confirm, phone, email, gender, RegDate);
			
		return "redirect:/Member_Mypage";
	}
	@RequestMapping(value = "/lost", method = RequestMethod.GET)
	public String forgotmember(Model model) {
		return "/registration/MemberIdandPassSearchForm";
	}
	
	@RequestMapping(value = "/idsearch", method = RequestMethod.POST)
	public String lostmember(Model model,@RequestParam(value = "name", required=false) String name,
			@RequestParam(value = "email", required=false) String email) {
		
		String userid=memberDao.findid(name, email);
		
		model.addAttribute("lostuser", userid);
		return "/registration/MemberIdandPassSearchForm";
	}
	
}
