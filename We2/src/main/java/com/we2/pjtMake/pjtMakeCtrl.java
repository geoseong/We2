package com.we2.pjtMake;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.we2.spring.AuthInfo;

@Controller
public class pjtMakeCtrl{
	
	private PjtMakeDAO pjtMakeDAO;
	public void setPjtMakeDAO(PjtMakeDAO pjtMakeDAO) {
		this.pjtMakeDAO = pjtMakeDAO;
	}

	@RequestMapping(value="/pjtMake", method=RequestMethod.POST)
	public String aoptest2(@ModelAttribute PjtMakeVO pjtMakeVO,HttpServletRequest request, HttpSession session, Model model) throws ParseException{
		
		//프로젝트 만들기를 클릭했을 때, 이 정보를 DB에 저장하는 DAO
		pjtMakeDAO.insertPjtMake(pjtMakeVO);
		
		//pjtManager에 디비를 추가 할 때 필요한 컬럼은(userId, pjtCode, isLeader)이다.
		//또한 프로젝트를 만드는 사람은 로그인한 사람이니 그 사람의 아이디를 불러와서 userId를 넘겨주고 또 리더로 지정해주면 된다.
		AuthInfo authInfo= (AuthInfo)session.getAttribute("authInfo");
		String userId = authInfo.getUserId(); 
		String name = authInfo.getName();
		
		// 방금 생성한 프로젝트 코드를 조회하는 DAO
		int pjtCode = pjtMakeDAO.selectCode();
		System.out.println("프로젝트를 만든 이 사람의 프로젝트 코드는 : " + pjtCode + " 입니다." );
		
		//필요한 컬럼을 다 받았으니 pjtManager를 추가한다.
		pjtMakeDAO.inserPjtManager(userId, pjtCode);
		
		System.out.println("프로젝트만들기 어디까지왔니? 여기는 매니저추가임!");
		//날짜 구하는 Dao 
		
		//프로젝트 생성후 날짜를 구해서 세션에 저장한다. 
		int dateSearch = pjtMakeDAO.searchDate(pjtCode);
		System.out.println("마지막 날짜와 시작날짜의 차 : " + dateSearch);
		session.setAttribute("day", dateSearch);
		
		System.out.println("내 아이디, 코드, 이름은 : " + userId + ", " + pjtCode +", " + name + "(이)야" );
		//프로젝트 생성 후 willwork에 대한 정보도 디비로 포함시켜야 나중에 할 일 부분에서 볼 수 있음
		pjtMakeDAO.insertWillWork(userId, pjtCode, name);
		System.out.println("할 일에 대한 작업이 성공했어! 거의 다왔어!!");
		
		//프로젝트 생성이 성공했습니다 메시지를 뿌려주기 위한 설정
		request.setAttribute("test", "success");
		return "/index";
		}
}