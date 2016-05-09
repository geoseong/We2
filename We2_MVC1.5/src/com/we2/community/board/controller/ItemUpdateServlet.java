package com.we2.community.board.controller;

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

/**
 * Servlet implementation class ProductUpdateServlet
 */
@WebServlet("/ItemUpdate")
public class ItemUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// 회원 로그인여부 검사.
		if(session.getAttribute("loginUser")==null){
			response.sendRedirect("/We2/01_main.html");
		}else{
		
			/* 조별과제 , 시험공부 , 회사협업 페이지를 판가름하는 파라미터(page)를 받아서 정의하기. */
				String url=null;
				String BoardDB = null;		
				
				String page = request.getParameter("page");
					System.out.println("ItemUpdateServlet doGet - page값 : " + page);
					
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

		//1. 글번호를 파라미터로 받아온다.
		int ItemNum = Integer.parseInt(request.getParameter("itemNum"));
			System.out.println("ItemUpdateServlet doGet - itemNum : " + ItemNum);
			
		// SQL문을 이용하는 클래스의 인스턴스화
		BoardDAO bDao = BoardDAO.getInstance();
		// 화면에 게시물들을 뿌려주기 위한 select쿼리문.
		BoardVO bVo = bDao.seeAllItemsforcontent(BoardDB, ItemNum);
		
		request.setAttribute("BoardUpdate", bVo);
		
		// 게시판 페이지 jsp 안의 jsp include에 들어갈 페이지 변수 보내기
		request.setAttribute("Boardpage", "ItemUpdate.jsp");
		
			System.out.println("(doGet) ItemUpdate url : " + url);
			System.out.println("----------------------ItemUpdateServlet doGet");
		RequestDispatcher dispatcher = request.getRequestDispatcher("BoardC/" + url + ".jsp");
		dispatcher.forward(request, response);
		
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" ------------------ ItemUpdateServlet doPost 시작");
		request.setCharacterEncoding("UTF-8");
		
		/* MultiPartRequest */
		ServletContext context=getServletContext();
		String path=context.getRealPath("BoardC/pic");
		System.out.println(path);
		String encType = "UTF-8";
		int sizeLimit = 20 * 1024 * 1024;
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());		
		
		
		/* 조별과제 , 시험공부 , 회사협업 페이지를 판가름하는 파라미터(page)를 받아서 정의하기. */
			String url=null;
			String BoardDB = null;		
			
			String page = multi.getParameter("page");
				System.out.println("page 파라미터 : " + page);
				
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
		
		//1. 글번호를 파라미터로 받아온다.
			int ItemNum = Integer.parseInt(multi.getParameter("itemNum"));
			
		// SQL문을 이용하는 클래스의 인스턴스화
		BoardDAO bDao = BoardDAO.getInstance();

		//2. 제목
			String ItemTitle=multi.getParameter("itemTitle");
		//3. 유저ID는 doGet에서 유효성 검사했으므로 update에서는 skip.
		//4. 게시물 작성일은 현재 날짜를 표시하는 sysdate를 DAO에서  내부적으로 처리.
		//5. 조회수는 update에서 skip
		//6. 파일경로
			String ItemPath=null;
			BoardVO bVo = new BoardVO();
			// 파일수정 아무것도 안하면 null값을 받아오는데, 파일이 날라갈 것을 방지하기위한 if문.
			if(multi.getFilesystemName("itemPath")!=null){
				ItemPath = multi.getFilesystemName("itemPath");
				System.out.println("자료 업뎃함.");
			}else{
				bVo = bDao.seeAllItemsforcontent(BoardDB, ItemNum);
				ItemPath = bVo.getItemPath();
				System.out.println("자료수정된 것 없음");
			}
		//7. 게시물 내용
			String ItemContent=multi.getParameter("itemContent");
					
			System.out.println("doPost itemNum --"+ItemNum);
			System.out.println("doPost itemTitle --"+ItemTitle);
			System.out.println("doPost itemPath --"+ItemPath);
			System.out.println("doPost itemContent --"+ItemContent);
		// SQL문 써먹기위해 BoardDAO 인스턴스화
			// 글번호, 제목, 게시물 작성일, 파일경로, 게시물 내용을 Update Set.
			int result=bDao.updateItem(BoardDB, ItemNum, ItemTitle, ItemPath, ItemContent);
				
			
			if(result==1){
				//게시물 등록 성공 메시지
				System.out.println("게시물 업데이트 성공");
			}else{
				//게시물 등록 실패. 다시 시도하세요
				System.out.println("게시물 업데이트 실패");
			}
			
		// 화면에 게시물들을 뿌려주기 위한 select쿼리문.
		//BoardVO update = bDao.seeAllItemsforcontent(ItemNum);
		//request.setAttribute("BoardUpdate", update);
		request.setAttribute("msg", "게시물 수정이 완료되었습니다.");
				
		
		// 게시판 페이지 jsp 안의 jsp include에 들어갈 페이지 변수 보내기
		request.setAttribute("Boardpage", "ItemList.jsp");
		
			System.out.println("(doPost) ItemUpdate url : " + url);
			System.out.println("----------------------ItemUpdateServlet doPost");

		RequestDispatcher dispatcher = request.getRequestDispatcher("ItemList?page="+page);
		dispatcher.forward(request, response);
	}

}
