package com.we2.studyroom;

import java.text.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.we2.studyroom.StudyRoomBean;


@Controller
@RequestMapping(value="/studyroom")
public class StudyRoomController {
	
	private static final Logger logger = LoggerFactory.getLogger(StudyRoomController.class);
	@Autowired
	StudyRoomService studyroomService;
	// 페이징처리 싱글톤 인스턴스객체 얻음
	RPagingManager paging = RPagingManager.getInstance();
	
	// 한 페이지에 표시할 레코드 수 정의
	int rows_per_page=10;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String listSpecificPageWork(@RequestParam("page") int page, Model model) throws ParseException{
		System.out.println("-------------------------------받아온 파라미터");
			System.out.println("rows_per_page : " + rows_per_page);
			System.out.println("page : " + page);
		System.out.println("-------------------------------변수설정 시작");
			// 시작 rownum 받아오기
			int row_start=0;
			row_start = paging.getFirstRowInPage(page, rows_per_page);
			System.out.println("row_start : " + row_start);
			
			// 끝 rownum 받아오기
			int row_end=0;
			row_end = paging.getLastRowInPage(page, rows_per_page);
			System.out.println("row_end : " + row_end);
		System.out.println("-------------------------------변수설정 끝");
		/*//디버깅 : 
			int size=content.size();
			for(int i=0; i < size ; i++){
				System.out.println("get ("+ i +") : "+boardService.getList(row_start, row_end).get(i).getItemDate());
				System.out.println("-------------------end of get(" + i + ")");
			} // 디버깅 끝 
*/	
		/* SECTION : REQUEST 영역에 보내기 */
		// SELECT 결과물
		  model.addAttribute("Content", studyroomService.getList(row_start, row_end));
		
		// JSP:INCLUDE PAGE
		  model.addAttribute("Boardpage", "StudyRoomList.jsp");
		
		
		System.out.println("--------------------------listSpecificPage");
		
		return "studyRoom/StudyRoomList";
	}



	
	
	// BoardWrite - 1) 
		@RequestMapping(value = "/studyroomwrite.do", method=RequestMethod.GET)  // ��Ʈ�ѷ��� ó���� ��û URL
		public String insertStudyRoom(Model model){
			logger.info("show_write_form called!!");
			
			model.addAttribute("StudyRoomBeanObjToWrite", new StudyRoomBean());
			
			return "studyRoom/StudyRoomWrite";
		}
		
		// BoardWrite - 2) 
		@RequestMapping(value="/studyroomwrite.do", method=RequestMethod.POST)
		public String studyroominsert2(StudyRoomBean StudyRoomBeanObjToWrite, Model model){
			logger.info("DoWriteBoard called!!");
			logger.info("memo=["+StudyRoomBeanObjToWrite.getRcontent()+"]");
			studyroomService.insertStudyRoom(StudyRoomBeanObjToWrite);
		/*	model.addAttribute("totalCnt", new Integer(studyroomService.getTotalCnt()));*/
			model.addAttribute("current_page", "1"); // ���� �ۼ��Ŀ��� ó�� �������� ���ư���
			model.addAttribute("StudyRoomList", studyroomService.getList(1, 2));
			return "studyRoom/StudyRoomList";
		}
		
		
	
}
