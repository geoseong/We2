package com.we2.scheduler;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.we2.spring.AuthInfo;



@Controller
@RequestMapping(value="/scheduler")
public class SchedulerController {
	
	private static final Logger logger = LoggerFactory.getLogger(SchedulerController.class);
	@Autowired
    private ServletContext servletContext;
	@Autowired
	SchedulerService schedulerService;
	@Autowired
	HttpServletRequest request;
	
	// 페이징처리 싱글톤 인스턴스객체 얻음
	RPagingManager paging = RPagingManager.getInstance();
	
	// 한 페이지에 표시할 레코드 수 정의
	int rows_per_page=9;
	int page_for_block=10;
		
	/* 리스트 */
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String listSpecificPageWork(Model model, int pjtcode) throws ParseException{
		model.addAttribute("Content", schedulerService.getlist(pjtcode));
		model.addAttribute("page", "../Scheduler/Calendar");
		System.out.println("--------------------------listSpecificPage");
		
		return "myproject/myproject";
	}
	
	

	//** 글쓰기 폼 띄우기 *//*
	@RequestMapping(value="/memoAdd.do", method=RequestMethod.GET)
	public String writeget(HttpSession session, HttpServletRequest request, Model model, int year, int month, int day){
		System.out.println("---글쓰기 페이지 진입");
		if(session.getAttribute("authInfo")!=null){
			System.out.println("로그인 되어있음.");
		}
		System.out.println("year : "+year + ", month : "+month + ", day : "+day);
		System.out.println("로그인 안됨");
		// JSP:INCLUDE PAGE
		  model.addAttribute("schedulerpage", "memoAdd");
		  model.addAttribute(Integer.toString(year));
		  model.addAttribute(Integer.toString(month));
		  model.addAttribute(Integer.toString(day));

		return "Scheduler/memoAdd";
	}
	
	
	/* 글 등록하기 */
	
	
	@RequestMapping(value="/memoAdd.do", method=RequestMethod.POST)
	public String writepost(HttpSession session, HttpServletRequest request, Model model)throws IOException {
		
		//SchedulerBean객체인 cVo에 변수들을 집어넣는다.
		SchedulerBean cVo = new SchedulerBean();
		//1. 글번호는 DAO의 SQL sequence로 내부적으로 처리.
		
		//2. 년도				
			int calendarmemo_year=Integer.parseInt("calendarmemo_year");
			cVo.setCalendarmemo_year(calendarmemo_year);
				System.out.println("WriteServlet - title : " + cVo.getCalendarmemo_num());
		//3. 달				
			int calendarmemo_month=Integer.parseInt("calendarmemo_month");
			cVo.setCalendarmemo_month(calendarmemo_month);
				System.out.println("WriteServlet - title : " + cVo.getCalendarmemo_month());
		//4. 일				
			int calendarmemo_day=Integer.parseInt("calendarmemo_day");
			cVo.setCalendarmemo_day(calendarmemo_day);
				System.out.println("WriteServlet - title : " + cVo.getCalendarmemo_day());
						
		//5. 메모내용
			String calendarmemo_contents = cVo.getCalendarmemo_contents();
			cVo.setCalendarmemo_contents(calendarmemo_contents);
				System.out.println("WriteServlet - boardpath : " + cVo.getCalendarmemo_contents());
				
		//6. 코드번호				
			int pjtcode=Integer.parseInt("pjtcode");
			cVo.setPjtcode(pjtcode);
				System.out.println("WriteServlet - title : " + cVo.getPjtcode());
		// 게시글 내용들을 Insert하기
			schedulerService.insertScheduler(pjtcode, calendarmemo_year, calendarmemo_month, calendarmemo_day, calendarmemo_contents);
			/*calendarmemo_num, calendarmemo_year, calendarmemo_month, calendarmemo_day, calendarmemo_contents*/
		// JSP:INCLUDE PAGE
		  model.addAttribute("schdulerpage", "Calendar");
		  model.addAttribute("page", 1);
		
		return "Scheduler/close";
	}
	
	/* 삭제하기*/ 

		@RequestMapping(value="/memoDelete.do", method=RequestMethod.GET)
		public String StudyRoomdelete(@RequestParam("calendarmemo_num") int calendarmemo_num, Model model) throws ParseException {
		
			// BoardDelete -
			  model.addAttribute("calendarmemo", schedulerService.getSearchbycalendarmemo_num(calendarmemo_num));	
			  // JSP:INCLUDE PAGE
			  model.addAttribute("schedulerpage", "memoDelete");
			  model.addAttribute("page", 1);
			return "Scheduler/memoDelete";   
		}
			
		@RequestMapping(value="/memoDelete.do", method=RequestMethod.POST)
		public String StudyRoomdeletepos(@RequestParam("calendarmemo_num") int calendarmemo_num, Model model) {
	
			schedulerService.deleteScheduler(calendarmemo_num);
			
			// JSP:INCLUDE PAGE
			  model.addAttribute("schedulerpage", "Calendar");
			  model.addAttribute("page", 1);
			return "Scheduler/close";   
		}
		
		
		
	 /*수정하기*/ 
		
		@RequestMapping(value="/memoUpdate.do", method=RequestMethod.GET)
		public String StudyRoomupdate(@RequestParam("calendarmemo_num") int calendarmemo_num, Model model) throws ParseException {
		
			
			// Update
			  model.addAttribute("calendarmemo", schedulerService.getSearchbycalendarmemo_num(calendarmemo_num));	
			  // JSP:INCLUDE PAGE
			  model.addAttribute("schedulerpage", "memoUpdate");
			  model.addAttribute("page", 1);
			return "Scheduler/memoUpdate";   
		}
			
		@RequestMapping(value="/memoUpdate.do", method=RequestMethod.POST)
		public String StudyRoomupdatepos(SchedulerBean studyRoomBean, Model model , HttpSession session) throws IOException {
			
			//PjtBoardBean객체인 cVo에 변수들을 집어넣는다.
			SchedulerBean cVo = new SchedulerBean();
			//1. 글번호는 DAO의 SQL sequence로 내부적으로 처리.
				int calendarmemo_num=Integer.parseInt("calendarmemo_num");
				cVo.setCalendarmemo_num(calendarmemo_num);
					System.out.println("WriteServlet - title : " + cVo.getCalendarmemo_num());
			//2. 년도				
				int calendarmemo_year=Integer.parseInt("calendarmemo_year");
				cVo.setCalendarmemo_year(calendarmemo_year);
					System.out.println("WriteServlet - title : " + cVo.getCalendarmemo_year());
			//3. 달				
				int calendarmemo_month=Integer.parseInt("calendarmemo_month");
				cVo.setCalendarmemo_month(calendarmemo_month);
					System.out.println("WriteServlet - title : " + cVo.getCalendarmemo_month());
			//4. 일				
				int calendarmemo_day=Integer.parseInt("calendarmemo_day");
				cVo.setCalendarmemo_day(calendarmemo_day);
					System.out.println("WriteServlet - title : " + cVo.getCalendarmemo_day());
							
			//5. 메모내용
				String calendarmemo_contents = cVo.getCalendarmemo_contents();
				cVo.setCalendarmemo_contents(calendarmemo_contents);
					System.out.println("WriteServlet - boardpath : " + cVo.getCalendarmemo_contents());
					
			//6. 코드번호				
				int pjtcode=Integer.parseInt("pjtcode");
				cVo.setPjtcode(pjtcode);
					System.out.println("WriteServlet - title : " + cVo.getPjtcode());
		// 게시글 내용들을 update 하기
		
			
			logger.info("updateRow called!!");			
			
			schedulerService.updateScheduler(pjtcode, calendarmemo_num, calendarmemo_year, calendarmemo_month, calendarmemo_day, calendarmemo_contents);
			/* JSP:INCLUDE PAGE*/
			  model.addAttribute("schedulerpage", "Calendar");
			  model.addAttribute("page", 1);
			  
			return "Scheduler/close";   
		}
		
	
	
	
}	
	