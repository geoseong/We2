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
	@Autowired
	HttpSession session;
	
	// 페이징처리 싱글톤 인스턴스객체 얻음
	RPagingManager paging = RPagingManager.getInstance();
	
	// 한 페이지에 표시할 레코드 수 정의
	int rows_per_page=9;
	int page_for_block=10;
		
	/* 리스트 */
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String listSpecificPageWork(Model model) throws ParseException{
			System.out.println("scheduler list.get] hi");
		
		int pjtCode = (Integer)session.getAttribute("pjtCode");
			System.out.println("scheduler list] pjtCode : "+pjtCode);
			
		model.addAttribute("Content", schedulerService.getlist(pjtCode));
		model.addAttribute("page", "../Scheduler/Calendar");
		System.out.println("--------------------------schedulerList");
		
		return "myproject/myproject";
	}
	
	

	//** 글쓰기 폼 띄우기 *//*
	@RequestMapping(value="/memoAdd.do", method=RequestMethod.GET)
	public String writeget(HttpSession session, HttpServletRequest request, Model model, int year, int month, int day){
		int pjtCode = (Integer)session.getAttribute("pjtCode");
			System.out.println("/memoAdd.do pjtcode : "+pjtCode);
		System.out.println("---글쓰기 페이지 진입");
		
		System.out.println("year : "+year + ", month : "+month + ", day : "+day);
		
		// JSP:INCLUDE PAGE
		  model.addAttribute("schedulerpage", "memoAdd");
		  model.addAttribute("year", year);
		  model.addAttribute("month", month);
		  model.addAttribute("day", day);
		  model.addAttribute("pjtcode", pjtCode);

		return "Scheduler/memoAdd";
	}
	
	
	/* 글 등록하기 */
	@RequestMapping(value="/memoAdd.do", method=RequestMethod.POST)
	public String writepost(/*HttpSession session, */HttpServletRequest request, Model model)throws IOException {
		
		//SchedulerBean객체인 cVo에 변수들을 집어넣는다.
		SchedulerBean cVo = new SchedulerBean();
		//1. 글번호는 DAO의 SQL sequence로 내부적으로 처리.
		System.out.println("scheduler 글쓰기");
	
		//2. 년도				
			int calendarmemo_year=Integer.parseInt(request.getParameter("calendarmemo_year"));
			cVo.setCalendarmemo_year(calendarmemo_year);
				System.out.println("WriteServlet - title : " + cVo.getCalendarmemo_num());
				System.out.println("calendarmemo_year 테스트"+calendarmemo_year);
		//3. 달				
			int calendarmemo_month=Integer.parseInt(request.getParameter("calendarmemo_month"));
			cVo.setCalendarmemo_month(calendarmemo_month);
				System.out.println("schduler - 달 : " + cVo.getCalendarmemo_month());
		//4. 일				
			int calendarmemo_day=Integer.parseInt(request.getParameter("calendarmemo_day"));
			cVo.setCalendarmemo_day(calendarmemo_day);
				System.out.println("schduler - 일 : " + cVo.getCalendarmemo_day());
						
		//5. 메모내용
			String calendarmemo_contents = request.getParameter("calendarmemo_contents");
					//cVo.getCalendarmemo_contents();
			cVo.setCalendarmemo_contents(calendarmemo_contents);
				System.out.println("schduler - 메모내용 : " + cVo.getCalendarmemo_contents());
		
				
    	//6 . 프로젝트 코드				
			int pjtCode = (Integer)session.getAttribute("pjtCode");
				System.out.println("/memoAdd.do POST pjtcode : "+pjtCode);
			cVo.setPjtcode(pjtCode);
				System.out.println("schduler - pjt코드 : " + cVo.getPjtcode());;
				
		// 게시글 내용들을 Insert하기
			schedulerService.insertScheduler(cVo.getCalendarmemo_year(), cVo.getCalendarmemo_month(), cVo.getCalendarmemo_day(), cVo.getCalendarmemo_contents(), cVo.getPjtcode());
			/*calendarmemo_num, calendarmemo_year, calendarmemo_month, calendarmemo_day, calendarmemo_contents*/

		// JSP:INCLUDE PAGE
		  model.addAttribute("schdulerpage", "Calendar");
		  model.addAttribute("page", 1);
		  model.addAttribute("msg", "글쓰기가 완료되었습니다.");
		return "Scheduler/close";
	}
	
	/* 삭제하기*/ 
	@RequestMapping(value="/memoDelete.do", method=RequestMethod.GET)
	public String StudyRoomdelete(@RequestParam("calendarmemo_num") int calendarmemo_num, Model model) throws ParseException {
	
		int pjtCode = (Integer)session.getAttribute("pjtCode");
			System.out.println("/memoDelete.do GET pjtcode : "+pjtCode);
		// BoardDelete -
		  model.addAttribute("calendarmemo", schedulerService.getSearchbycalendarmemo_num(calendarmemo_num, pjtCode));	
		  // JSP:INCLUDE PAGE
		  model.addAttribute("schedulerpage", "memoDelete");
		  model.addAttribute("page", 1);
		return "Scheduler/memoDelete";   
	}
			
	@RequestMapping(value="/memoDelete.do", method=RequestMethod.POST)
	public String StudyRoomdeletepos(@RequestParam("calendarmemo_num") int calendarmemo_num, Model model) {
		
		System.out.println("/memoDelete.do POST calendarmemo_num : "+calendarmemo_num);
		int pjtCode = (Integer)session.getAttribute("pjtCode");
			System.out.println("/memoDelete.do POST pjtcode : "+pjtCode);
		schedulerService.deleteScheduler(calendarmemo_num, pjtCode);
		
		// JSP:INCLUDE PAGE
		  model.addAttribute("schedulerpage", "Calendar");
		  model.addAttribute("page", 1);
		  model.addAttribute("msg", "삭제가 완료되었습니다.");
		return "Scheduler/close";   
	}
		
		
		
	 /*수정하기*/ 
		@RequestMapping(value="/memoUpdate.do", method=RequestMethod.GET)
		public String StudyRoomupdate(@RequestParam("calendarmemo_num") int calendarmemo_num, Model model) throws ParseException {
			System.out.println("/memoupdate.get 시작");
			
			int pjtCode = (Integer)session.getAttribute("pjtCode");
				System.out.println("/memoUpdate.do GET pjtcode : "+pjtCode);
			// Update
			  model.addAttribute("calendarmemo", schedulerService.getSearchbycalendarmemo_num(calendarmemo_num, pjtCode));
			  
			  String contents = schedulerService.getSearchbycalendarmemo_num(calendarmemo_num, pjtCode).getCalendarmemo_contents().replace("\r\n","<br>");
			  System.out.println("contents : " + contents);
			  // JSP:INCLUDE PAGE
			  model.addAttribute("schedulerpage", "memoUpdate");
			  model.addAttribute("page", 1);
			  model.addAttribute("calcontents",contents);
			return "Scheduler/memoUpdate";   
		}
			
		@RequestMapping(value="/memoUpdate.do", method=RequestMethod.POST)
		public String StudyRoomupdatepos(Model model , HttpSession session) throws IOException {
			
			System.out.println("/memoupdate.post 시작");
			
			//PjtBoardBean객체인 cVo에 변수들을 집어넣는다.
			SchedulerBean cVo = new SchedulerBean();
			//1. 글번호는 DAO의 SQL sequence로 내부적으로 처리.
				int calendarmemo_num=Integer.parseInt(request.getParameter("calendarmemo_num"));
				cVo.setCalendarmemo_num(calendarmemo_num);
					System.out.println("modify - calendarmemo_num : " + cVo.getCalendarmemo_num());
			//2. 년도				
				int calendarmemo_year=Integer.parseInt(request.getParameter("calendarmemo_year"));
				cVo.setCalendarmemo_year(calendarmemo_year);
					System.out.println("modify - calendarmemo_year : " + cVo.getCalendarmemo_year());
			//3. 달				
				int calendarmemo_month=Integer.parseInt(request.getParameter("calendarmemo_month"));
				cVo.setCalendarmemo_month(calendarmemo_month);
					System.out.println("modify - calendarmemo_month : " + cVo.getCalendarmemo_month());
			//4. 일				
				int calendarmemo_day=Integer.parseInt(request.getParameter("calendarmemo_day"));
				cVo.setCalendarmemo_day(calendarmemo_day);
					System.out.println("modify - calendarmemo_day : " + cVo.getCalendarmemo_day());
							
			//5. 메모내용
				String calendarmemo_contents = request.getParameter("calendarmemo_contents");
						//cVo.getCalendarmemo_contents();
				cVo.setCalendarmemo_contents(calendarmemo_contents);
					System.out.println("WriteServlet - boardpath : " + cVo.getCalendarmemo_contents());
					
			//6. 코드번호				
				int pjtCode = (Integer)session.getAttribute("pjtCode");
					System.out.println("/memoUpdate.do GET pjtcode : "+pjtCode);
				cVo.setPjtcode(pjtCode);
					System.out.println("WriteServlet - pjtcode : " + cVo.getPjtcode());
					
		// 게시글 내용들을 update 하기
			logger.info("updateRow called!!");			
			schedulerService.updateScheduler(pjtCode, calendarmemo_num, calendarmemo_year, calendarmemo_month, calendarmemo_day, calendarmemo_contents);

			/* JSP:INCLUDE PAGE*/
			  model.addAttribute("schedulerpage", "Calendar");
			  model.addAttribute("page", 1);
			  model.addAttribute("msg", "수정이 완료되었습니다.");
			return "Scheduler/close";   
		}
}	
	