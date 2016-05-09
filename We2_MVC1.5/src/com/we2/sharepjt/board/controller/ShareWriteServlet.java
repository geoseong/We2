package com.we2.sharepjt.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.we2.community.board.dao.BoardDAO;
import com.we2.community.board.dto.BoardVO;
import com.we2.registration.dto.We2_MemberVO;

/**
 * Servlet implementation class ProductWriteServlet
 */
@WebServlet("/ShareWrite")
public class ShareWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// 회원 로그인여부 검사.
		if(session.getAttribute("loginUser")==null){
			response.sendRedirect("/We2/index.jsp");
		}else{			
			
			/* 조별과제 , 시험공부 , 회사협업 페이지를 판가름하는 파라미터(page)를 받아서 정의하기. */
			String url=null;
			String BoardDB = null;		
			
			String page = request.getParameter("page");
			
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
						

			System.out.println("ItemWrite : 로그인 성공했으니 doGet으로 ItemWrite.");
			// 게시판 페이지 jsp 안의 jsp include에 들어갈 페이지 변수 보내기
			request.setAttribute("Boardpage", "ItemWrite.jsp");
			

				System.out.println("(doGet) ItemWriteServlet url : " + url);
				System.out.println("----------------------ItemWriteServlet doGet");
			RequestDispatcher dispatcher = request.getRequestDispatcher("BoardP/" + url + ".jsp");
			dispatcher.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		/* 조별과제 , 시험공부 , 회사협업 페이지를 판가름하는 파라미터(page)를 받아서 정의하기. */
		String url=null;
		String BoardDB = null;		
		
		String page = request.getParameter("page");
		
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

		ServletContext context= getServletContext();		
		String path=context.getRealPath("BoardP/pic");
		System.out.println(path);
		// getRealPath 
		// : E:\JavaSmartWeb\mywork_web\.metadata\.plugins\org.eclipse.wst.server.core\tmp2\wtpwebapps\testweb\
		String encType="UTF-8";
		int sizeLimit = 20*1024*1024;
		
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
		
		HttpSession session = request.getSession();
		
		//BoardVo객체인 pVo에 변수들을 집어넣는다.
			BoardVO pVo = new BoardVO();
		//1. 글번호는 DAO의 SQL sequence로 내부적으로 처리.
		//2. 제목
			String title=multi.getParameter("title");
			pVo.setItemTitle(title);
				System.out.println("WriteServlet - title : " + pVo.getItemTitle());
		//3. 유저ID는 세션에 떠돌아다니는 (로그인중인) 변수를 getAttribute하면 됨
			We2_MemberVO mVo = (We2_MemberVO)session.getAttribute("loginUser");
			String userid=mVo.getUserid();
			pVo.setUserId(userid);
				System.out.println("WriteServlet - userid : " + pVo.getUserId());
		//4. 게시물 작성일은 현재 날짜를 표시하는 sysdate를 DAO에서  내부적으로 처리.
		//5. 조회수는 방문할때 doGet방식 - count하라는 파라미터를 넘길때만 +1 하면 될듯
			// 일단 조회수 0으로 초기화.
			pVo.setItemClick(0);
				System.out.println("WriteServlet - 조회수 : " + pVo.getItemClick());
		//6. 파일경로
			String boardpath = multi.getFilesystemName("path");
			pVo.setItemPath(boardpath);
				System.out.println("WriteServlet - boardpath : " + pVo.getItemPath());
		//7. 게시물 내용
			String content=multi.getParameter("context");
			pVo.setItemContent(content);
				System.out.println("WriteServlet - content : " + pVo.getItemContent());
					
		// SQL문 써먹기위해 BoardDAO 인스턴스화
		// 게시글 내용들을 Insert하기
			BoardDAO pDao = BoardDAO.getInstance();
			int result=pDao.InsertItem(BoardDB, pVo);
			
			if(result==1){
				//게시물 등록 성공 메시지
				System.out.println("게시물 등록 성공");
				request.setAttribute("msg", "게시물 등록이 완료되었습니다.");
			}else{
				//게시물 등록 실패. 다시 시도하세요
				System.out.println("게시물 등록 실패");
				request.setAttribute("msg", "게시물 등록에 실패하였습니다.");
			}

		// 게시판 페이지 jsp 안의 jsp include에 들어갈 페이지 변수 보내기
		request.setAttribute("Boardpage", "ItemList.jsp");
		

					System.out.println("(doPost) ItemWriteServlet url : " + url);
					System.out.println("----------------------ItemWriteServlet doPost");
		RequestDispatcher dispatcher=request.getRequestDispatcher("ShareList?page="+page);
		dispatcher.forward(request, response);
	}
}