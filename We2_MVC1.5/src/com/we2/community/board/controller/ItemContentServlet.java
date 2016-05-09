package com.we2.community.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.we2.community.board.dao.BoardDAO;
import com.we2.community.board.dto.BoardVO;

/**
 * Servlet implementation class ItemContentServlet
 */
@WebServlet("/ItemContent")
public class ItemContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
				response.sendRedirect("01_main.html");
			}// end if
			
			System.out.println("테이블명 : " + BoardDB);
	
			request.setAttribute("page", page);
		/* DB , 페이지 변수 정의 끝*/

		int ItemNum=Integer.parseInt(request.getParameter("itemNum"));
			System.out.println("(Content-doGet)ItemNum - " + ItemNum);
		int added = 0;
		
		// SQL 클래스 객체 인스턴스화.
		BoardDAO bDao = BoardDAO.getInstance();
		// 화면에 게시물들을 뿌려주기 위한 select쿼리문.
		BoardVO bVo = bDao.seeAllItemsforcontent(BoardDB, ItemNum);
		
		added = bDao.addcounter(BoardDB, bVo);
			System.out.println("addcounter 메소드 실행함");
	
		if(added==1){
			System.out.println("카운터 1 추가 성공");
		}else{
			System.out.println("카운터 추가 안됨");
		}
		
		// select 결과를 담은 BoardVO pVo 객체를 request영역에다 보냄.
		request.setAttribute("BoardContent", bVo);
		
		// 게시판 페이지 jsp 안의 jsp include에 들어갈 페이지 변수 보내기
		request.setAttribute("Boardpage", "ItemContent.jsp");
		
			System.out.println("(doGet) ItemContent url : " + url);
			System.out.println("----------------------ItemContentServlet doGet");
			
		RequestDispatcher dispatcher = request.getRequestDispatcher("BoardC/" + url + ".jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
