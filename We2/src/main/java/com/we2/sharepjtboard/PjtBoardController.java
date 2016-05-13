package com.we2.sharepjtboard;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/pjtBoard")
public class PjtBoardController {
	
	@Autowired
	PjtBoardService boardService;
	// 페이징처리 싱글톤 인스턴스객체 얻음
	PagingManager paging = PagingManager.getInstance();
	
	// 한 페이지에 표시할 레코드 수 정의
	int rows_per_page=10;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String listSpecificPageWork(@RequestParam("page") int page, Model model){
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
		
		//임시 : ArrayList<PjtBoardBean> content =boardService.getList(row_start, row_end); 
		boardService.getList(row_start, row_end);
		
		/*//디버깅 : 
			int size=content.size();
			for(int i=0; i < size ; i++){
				System.out.println("get ("+ i +") : "+boardService.getList(row_start, row_end).get(i).getItemDate());
				System.out.println("-------------------end of get(" + i + ")");
			} // 디버깅 끝 
*/	
		/* SECTION : REQUEST 영역에 보내기 */
		// SELECT 결과물
		//임시 : model.addAttribute("Content", content);
		// JSP:INCLUDE PAGE
		model.addAttribute("Boardpage", "list.jsp");
		
		System.out.println("--------------------------listSpecificPage");
		
		return "pjtBoard/boardmain";
	}
	
	@RequestMapping(value="/modal", method=RequestMethod.GET)
	public String testmodal(){
		return "test_modal/jqueryModal";
	}
	
}
