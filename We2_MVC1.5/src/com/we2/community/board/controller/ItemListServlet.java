package com.we2.community.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.we2.community.board.dao.BoardDAO;
import com.we2.community.board.dto.BoardVO;

/**
 * Servlet implementation class ProductListServlet
 */
@WebServlet("/ItemList")
public class ItemListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		/* 조별과제 , 시험공부 , 회사협업 페이지를 판가름하는 파라미터(page)를 받아서 정의하기. */
			String url=null;
			String BoardDB = null;		
			
			String page = request.getParameter("page");
			
			if(page==null || page.equals("group")){	
				// 서블릿에서 보낼 url - GroupBoard
					url = "GroupBoard";		
				// 지정될 DB명 설정.
					BoardDB = "cTeamWork";			
					System.out.println("case1");
					page = "group";
			}else if(page.equals("exam")){
				// 서블릿에서 보낼 url - ExamBoard
					url = "ExamBoard";	
				// 지정될 DB명 설정
					BoardDB = "cTest";							
					System.out.println("case2");
			}else if(page.equals("collabo")){			
				// 서블릿에서 보낼 url - CollaboBoard 
					url = "CollaboBoard";			
				// 지정될 DB명 설정.	
					BoardDB = "cWithWork";		
					System.out.println("case3");
			}else{
				response.sendRedirect("index.jsp");
			}// end if
			
			System.out.println("테이블명 : " + BoardDB);

			request.setAttribute("page", page);
		/* DB , 페이지 변수 정의 끝*/
		
		System.out.println("ItemList - page파라미터 받은 값 : "+ request.getParameter("page"));
		System.out.println("ItemList - url 값 : " + url);	
								
		
	/** 페이징 기법*/
		int pagelink=1;
		int startRcdNo=1;
		
	// pagelink, startRcdNo 파라미터를 받는다.받은 게 없다면, 맨 첫페이지 출력
		if(request.getParameter("pagelink")!=null){
			 pagelink = Integer.parseInt(request.getParameter("pagelink"));
		}else{
			 System.out.println("pagelink 파라미터는 null이다");
		}
		
		if(request.getParameter("startRcdNo")!=null){
			 startRcdNo=Integer.parseInt(request.getParameter("startRcdNo"));
		}else{
			 System.out.println("startRcdNo 파라미터는 null이다");
		}		
		
/** find 파라미터값을 받으면 Search모드. */
		if(request.getParameter("find")!=null){
			System.out.println("★ ItemListServlet = 검색모드");
			// 콤보박스와 내용 파라미터 받아오기				
			String find=null;				
			String findword=request.getParameter("findword");				
							
			if(request.getParameter("find").equals("itemNum")){				
				find="itemNum";			
			}else if(request.getParameter("find").equals("userId")){				
				find="userId";			
			}else{				
				find="itemContent";			
			}				
							
			System.out.println("find값 : " + find);				
			System.out.println("findword값 : " + findword);				
							
			//SQL문을 쓰기 위한 인스턴스화				
			BoardDAO bDao = BoardDAO.getInstance();				
							
			/** 페이징 기법 시작 */				
			// 게시판 테이블의 총 레코드개수 구하기				
			int totrcds = bDao.countsearchedRecords(BoardDB, find, findword);				
			System.out.println("SearchServlet totrcds : " + totrcds);				
							
			// 페이지에 나오는 페이지개수 정의				
				int rcdsinone = 10;			
							
			// 파라미터 : 총레코드개수 , 하단의 표시되는 페이지개수, 각 페이지에 나오는 레코드개수				
			PagingCount pgcnt = new PagingCount(totrcds, 10, rcdsinone);				
							
			// List result변수에 검색값과 페이징기법을 적용한 SQL문의 결과를 받음				
			// request영역에 결과값 list 보냄.				
			int endpage = startRcdNo+rcdsinone;				
			List<BoardVO> result = bDao.searchItem(BoardDB, find, findword, startRcdNo, endpage);				
							
			// jsp의 EL영역에 보낼 변수 정의				
			request.setAttribute("BoardList", result);				
							
			// find와 findword의 변수를 attribute로 보냄.				
			request.setAttribute("find", find);				
			request.setAttribute("findword", findword);				
							
			// 게시판 페이지 jsp 안의 jsp include에 들어갈 페이지 변수 보내기				
			request.setAttribute("Boardpage", "ItemList.jsp");				
							
			// 하단에 페이징기법 태그를 얻어내는 메소드.				
			String pagecounting = pgcnt.showSearchPaging(pagelink, "ItemList", find, findword, page);				
							
			// 페이징기법 태그를 request영역에 보냄				
			request.setAttribute("pagecounting", pagecounting);				
			System.out.println("----------------------ItemListServlet doPost");				
		
		}else{
 /** find 파라미터값이 없으면 일반 리스트 뿌리기 */
			System.out.println("ItemListServlet = 일반 리스트모드");
			// 페이지에 나오는 레코드개수 정의
			int rcdsinone = 10;
			
			//SQL문을 쓰기 위한 인스턴스화
			BoardDAO bDao = BoardDAO.getInstance();	
			
			// 게시판 테이블의 총 레코드개수 구하기
			int totrcds = bDao.countRecords(BoardDB);
			
			// 파라미터 : 총레코드개수 , 하단의 표시되는 페이지개수, 각 페이지에 나오는 레코드개수
			PagingCount pgcnt = new PagingCount(totrcds, 10, rcdsinone);
			
			// 하단에 페이징기법 태그를 얻어내는 메소드.
			String pagecounting = pgcnt.showPaging(pagelink, "ItemList");
			
			// 화면에 게시물들을 뿌려주기 위한 select쿼리문.
			int endpage = startRcdNo+rcdsinone;
			List<BoardVO> BoardList = bDao.seeAllItems(BoardDB, startRcdNo, endpage);
			
			
			// request영역에 "BoardList" 이름으로 변수 보냄
				request.setAttribute("BoardList", BoardList);
					
			// 페이징기법 태그를 request영역에 보냄
			request.setAttribute("pagecounting", pagecounting);	
			
			// 게시판 페이지 jsp 안의 jsp include에 들어갈 페이지 변수 보내기
			request.setAttribute("Boardpage", "ItemList.jsp");
			
			System.out.println("url : " + url);
			System.out.println("----------------------ItemListServlet doGet");
		} //end 일반 리스트뿌리기
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("BoardC/" + url + ".jsp");
		dispatcher.forward(request, response);
	} //end doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	} //end doPost

}
