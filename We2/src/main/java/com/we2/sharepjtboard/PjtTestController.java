/*package com.we2.sharepjtboard;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/pjtBoard/test")
public class PjtTestController {
	
	@Autowired
	PjtBoardService boardService;
	
	// 페이징처리 싱글톤 인스턴스객체 얻음
	PagingManager paging = PagingManager.getInstance();
	
	// 한 페이지에 표시할 레코드 수 정의
	int rows_per_page=10;
	// 한 화면에 표시할 페이지 수 정의
	int page_for_block=10;
	
	 리스트 
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String listget(@RequestParam("page") int page, Model model) throws ParseException {
		System.out.println("-------------------------------받아온 파라미터");
			System.out.println("rows_per_page : " + rows_per_page);
			System.out.println("page : " + page);
		System.out.println("-------------------------------변수설정 시작");
		
			// 시작 rownum 받아오기
			int row_start= paging.getFirstRowInPage(page, rows_per_page);
			System.out.println("row_start : " + row_start);
			
			// 끝 rownum 받아오기
			int row_end=paging.getLastRowInPage(page, rows_per_page);
			System.out.println("row_end : " + row_end);
			
			// 토탈 row, page 구하기
			int t_rows = boardService.getTotalCnt();
			int t_pages = paging.getTotalPage(t_rows, rows_per_page);
			
			// 블락설정 : 한 화면에 표시될 페이지를 토대로 page세션1(1~10), page세션2(11~20)을 정의
			int block=paging.getPageBlock(page, page_for_block);
			int block_total=paging.getPageBlock(t_pages, page_for_block);
			int block_first=paging.getFirstPageInBlock(block, page_for_block);
			int block_last=paging.getLastPageBlock(block, page_for_block);
			if(block_last>t_pages){
				System.out.println("--block_last가 t_pages보다 크므로 내용이 존재하는 페이지만큼만 block_last를 조절.");
				block_last=t_pages;
			}
			System.out.println("t_pages : " + t_pages +" , t_rows : "+t_rows+" , block_total : "+block_total+" , block : "+ block + " , block_first : " + block_first + " , block_last : " + block_last);
		System.out.println("-------------------------------변수설정 끝");
		
		*//** SECTION : REQUEST 영역에 보내기 *//*
		// SELECT 결과물
			model.addAttribute("Content", boardService.getformatDate(row_start, row_end));
		// JSP:INCLUDE PAGE
		  model.addAttribute("Boardpage", "list.jsp");
		// total page int 변수를 보냄
		  model.addAttribute("t_pages", t_pages);
		// 현재 페이지 번호를 보냄
		  model.addAttribute("c_page", page);
		// 페이지 블락 보냄
		  model.addAttribute("block", block);
		  model.addAttribute("block_first",block_first);
		  model.addAttribute("block_last",block_last);
		  model.addAttribute("block_total",block_total);
		  model.addAttribute("page_for_block", page_for_block);
		System.out.println("--------------------------listSpecificPage");
		
		return "pjtBoard/boardmain";
	}
	
	*//** 글쓰기 폼 띄우기 *//*
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String writeget(Model model, PjtBoardBean pjtboardbean){
		// JSP:INCLUDE PAGE
		  model.addAttribute("Boardpage", "write.jsp");
		return "pjtBoard/boardmain";
	}
	
	*//** 글 등록하기 *//*
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String writepost(Model model, PjtBoardBean pjtboardbean){
		
		// JSP:INCLUDE PAGE
		  model.addAttribute("Boardpage", "list.jsp");
		return "pjtBoard/boardmain";
	}
	
}
*/