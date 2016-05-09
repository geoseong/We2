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

		/* �������� , ������� , ȸ������ �������� �ǰ����ϴ� �Ķ����(page)�� �޾Ƽ� �����ϱ�. */
			String url=null;
			String BoardDB = null;		
			
			String page = request.getParameter("page");
			
			if(page==null || page.equals("group")){	
				// �������� ���� url - GroupBoard
					url = "GroupBoard";		
				// ������ DB�� ����.
					BoardDB = "cTeamWork";			
					System.out.println("case1");
					page = "group";
			}else if(page.equals("exam")){
				// �������� ���� url - ExamBoard
					url = "ExamBoard";	
				// ������ DB�� ����
					BoardDB = "cTest";							
					System.out.println("case2");
			}else if(page.equals("collabo")){			
				// �������� ���� url - CollaboBoard 
					url = "CollaboBoard";			
				// ������ DB�� ����.	
					BoardDB = "cWithWork";		
					System.out.println("case3");
			}else{
				response.sendRedirect("01_main.html");
			}// end if
			
			System.out.println("���̺�� : " + BoardDB);
	
			request.setAttribute("page", page);
		/* DB , ������ ���� ���� ��*/

		int ItemNum=Integer.parseInt(request.getParameter("itemNum"));
			System.out.println("(Content-doGet)ItemNum - " + ItemNum);
		int added = 0;
		
		// SQL Ŭ���� ��ü �ν��Ͻ�ȭ.
		BoardDAO bDao = BoardDAO.getInstance();
		// ȭ�鿡 �Խù����� �ѷ��ֱ� ���� select������.
		BoardVO bVo = bDao.seeAllItemsforcontent(BoardDB, ItemNum);
		
		added = bDao.addcounter(BoardDB, bVo);
			System.out.println("addcounter �޼ҵ� ������");
	
		if(added==1){
			System.out.println("ī���� 1 �߰� ����");
		}else{
			System.out.println("ī���� �߰� �ȵ�");
		}
		
		// select ����� ���� BoardVO pVo ��ü�� request�������� ����.
		request.setAttribute("BoardContent", bVo);
		
		// �Խ��� ������ jsp ���� jsp include�� �� ������ ���� ������
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
