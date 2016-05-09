package com.we2.sharepjt.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.we2.community.board.dao.BoardDAO;

/**
 * Servlet implementation class ItemDeleteServlet
 */
@WebServlet("/ShareDelete")
public class ShareDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		// 회원 로그인여부 검사.
		if(session.getAttribute("loginUser")==null){
			response.sendRedirect("/We2/01_main.html");
		}else{
			
			/* 조별과제 , 시험공부 , 회사협업 페이지를 판가름하는 파라미터(page)를 받아서 정의하기. */
				String url=null;
				String BoardDB = null;		
				
				String page = request.getParameter("page");
				System.out.println("ItemDelete - page : " + page);
				
				if(page==null || page.equals("group")){	
					// 서블릿에서 보낼 url - GroupBoard
						url = "GroupBoard";		
					// 지정될 DB명 설정.
						BoardDB = "pTeamWork";			
						System.out.println("case1");
						page = "group";
				}else if(page.equals("exam")){
					// 서블릿에서 보낼 url - ExamBoard
						url = "ExamBoard";	
					// 지정될 DB명 설정
						BoardDB = "pTest";							
						System.out.println("case2");
				}else if(page.equals("collabo")){			
					// 서블릿에서 보낼 url - CollaboBoard 
						url = "CollaboBoard";			
					// 지정될 DB명 설정.	
						BoardDB = "pWithWork";		
						System.out.println("case3");
				}else{
					response.sendRedirect("01_main.html");
				}// end if
				
				System.out.println("테이블명 : " + BoardDB);
	
				request.setAttribute("page", page);
			/* DB , 페이지 변수 정의 끝*/
		
		//1. 글번호를 파라미터로 받아온다.
			int ItemNum=Integer.parseInt(request.getParameter("itemNum"));
			System.out.println("delete(doget) - ItemNum : " + ItemNum);
			
		// SQL문을 쓰기 위한 객체 인스턴스화
			BoardDAO bDao = BoardDAO.getInstance();
		
		// 게시글 지우는 SQL문 시전.
			int result = bDao.deleteItem(BoardDB, ItemNum);
			
			if(result==1){
				request.setAttribute("msg","해당 게시물 삭제를 완료하였습니다.");
				System.out.println("게시물 삭제 성공");
			}else{
				request.setAttribute("msg","해당 게시물 삭제에 실패하였습니다. 다시 시도해 주세요.");
				System.out.println("게시물 삭제 실패");
			}
					
			// 게시판 페이지 jsp 안의 jsp include에 들어갈 페이지 변수 보내기
			request.setAttribute("Boardpage", "ItemList.jsp");
			
				System.out.println("(doGet) ItemDeleteServlet url : " + url);
				System.out.println("----------------------ItemDeleteServlet doGet");
				
			RequestDispatcher dispatcher=request.getRequestDispatcher("ShareList?page="+page);
			dispatcher.forward(request, response);
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
