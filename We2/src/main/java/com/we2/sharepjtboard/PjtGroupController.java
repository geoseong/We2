package com.we2.sharepjtboard;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.we2.spring.AuthInfo;

@Controller
@RequestMapping(value="/pjtBoard/group")
public class PjtGroupController {
	
	@Autowired
	PjtBoardService boardService;
	@Autowired
    private ServletContext servletContext;
	
	// 페이징처리 싱글톤 인스턴스객체 얻음
	PagingManager paging = PagingManager.getInstance();
	
	// 한 페이지에 표시할 레코드 수 정의
	int rows_per_page=10;
	// 한 화면에 표시할 페이지 수 정의
	int page_for_block=10;
	
	/* 리스트 */
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String listget(@RequestParam("page") int page, String category, Model model) throws ParseException {
		System.out.println("-------------------------------받아온 파라미터");
			System.out.println("rows_per_page : " + rows_per_page);
			System.out.println("page : " + page);
		System.out.println("-------------------------------변수설정 시작");

		if(category.equals("group")){
			category="pGroup";
		}else if(category.equals("exam")){
			category="pTest";
		}else if(category.equals("collabo")){
			category="pWithWork";
		}
			// 시작 rownum 받아오기
			int row_start= paging.getFirstRowInPage(page, rows_per_page);
			System.out.println("row_start : " + row_start);
			
			// 끝 rownum 받아오기
			int row_end=paging.getLastRowInPage(page, rows_per_page);
			System.out.println("row_end : " + row_end);
			
			// 토탈 row, page 구하기
			int t_rows = boardService.getTotalCnt(category);
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
		
		/** SECTION : REQUEST 영역에 보내기 */
		// ★★ SELECT 결과물 ★★
			model.addAttribute("Content", boardService.getformatDate(category, row_start, row_end));
		// JSP:INCLUDE PAGE
		  model.addAttribute("Boardpage", "list");
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
		// category 보냄
		  model.addAttribute("category", category);
		System.out.println("--------------------------listSpecificPage");
		
		return "pjtBoard/boardmain";
	}
	
	/** 글쓰기 폼 띄우기 */
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String writeget(HttpSession session, HttpServletRequest request, Model model, PjtBoardBean pjtboardbean, String category){
		System.out.println("---글쓰기 페이지 진입");
		if(session.getAttribute("authInfo")!=null){
			System.out.println("로그인 되어있음.");
		}
		System.out.println("로그인 안됨");
		// JSP:INCLUDE PAGE
		  model.addAttribute("Boardpage", "write");
		// category 보냄
		  model.addAttribute("category", category); 
		return "pjtBoard/boardmain";
	}
	
	/** 글 등록하기 
	 * @throws IOException */
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String writepost(HttpSession session, HttpServletRequest request, Model model, String category) throws IOException {
	    // 해당 경로의 폴더가 안만들어져있다면 직접 만들어놔야할 것.
		String path=servletContext.getRealPath("we2/pjtBoard/data");
		System.out.println("path : "+path);
		// getRealPath : E:\JavaSmartWeb\mywork_web\.metadata\.plugins\org.eclipse.wst.server.core\tmp2\wtpwebapps\testweb\
		String encType="UTF-8";
		int sizeLimit = 20*1024*1024;
		
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
		
		//PjtBoardBean객체인 pVo에 변수들을 집어넣는다.
		PjtBoardBean pVo = new PjtBoardBean();
		//1. 글번호는 DAO의 SQL sequence로 내부적으로 처리.
		//2. 제목
			String title=multi.getParameter("title");
			pVo.setItemTitle(title);
				System.out.println("WriteServlet - title : " + pVo.getItemTitle());
		//3. 유저ID는 세션에 떠돌아다니는 (로그인중인) 변수를 getAttribute하면 됨
			AuthInfo mVo = (AuthInfo)session.getAttribute("authInfo");
			pVo.setUserId(mVo.getUserId());
				System.out.println("WriteServlet - userid : " + pVo.getUserId());
		//4. 게시물 작성일은 현재 날짜를 표시하는 sysdate를 DAO에서  내부적으로 처리.
		//5. 조회수는 방문할때 doGet방식 - count하라는 파라미터를 넘길때만 +1 하면 될듯
		//6. 파일경로
			String boardpath = multi.getFilesystemName("path");
			pVo.setItemPath(boardpath);
				System.out.println("WriteServlet - boardpath : " + pVo.getItemPath());
		//7. 게시물 내용
			String content=multi.getParameter("context");
			pVo.setItemContent(content);
				System.out.println("WriteServlet - content : " + pVo.getItemContent());
					
		// 게시글 내용들을 Insert하기
			boardService.insertBoard(category, pVo);
		
		// JSP:INCLUDE PAGE
		  model.addAttribute("Boardpage", "list");
		  model.addAttribute("page", 1);
		// category 보냄
		  model.addAttribute("category", category);
		return "redirect:list";
	}
	
}
