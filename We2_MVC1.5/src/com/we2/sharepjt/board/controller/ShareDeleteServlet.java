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
		// ȸ�� �α��ο��� �˻�.
		if(session.getAttribute("loginUser")==null){
			response.sendRedirect("/We2/01_main.html");
		}else{
			
			/* �������� , ������� , ȸ������ �������� �ǰ����ϴ� �Ķ����(page)�� �޾Ƽ� �����ϱ�. */
				String url=null;
				String BoardDB = null;		
				
				String page = request.getParameter("page");
				System.out.println("ItemDelete - page : " + page);
				
				if(page==null || page.equals("group")){	
					// �������� ���� url - GroupBoard
						url = "GroupBoard";		
					// ������ DB�� ����.
						BoardDB = "pTeamWork";			
						System.out.println("case1");
						page = "group";
				}else if(page.equals("exam")){
					// �������� ���� url - ExamBoard
						url = "ExamBoard";	
					// ������ DB�� ����
						BoardDB = "pTest";							
						System.out.println("case2");
				}else if(page.equals("collabo")){			
					// �������� ���� url - CollaboBoard 
						url = "CollaboBoard";			
					// ������ DB�� ����.	
						BoardDB = "pWithWork";		
						System.out.println("case3");
				}else{
					response.sendRedirect("01_main.html");
				}// end if
				
				System.out.println("���̺�� : " + BoardDB);
	
				request.setAttribute("page", page);
			/* DB , ������ ���� ���� ��*/
		
		//1. �۹�ȣ�� �Ķ���ͷ� �޾ƿ´�.
			int ItemNum=Integer.parseInt(request.getParameter("itemNum"));
			System.out.println("delete(doget) - ItemNum : " + ItemNum);
			
		// SQL���� ���� ���� ��ü �ν��Ͻ�ȭ
			BoardDAO bDao = BoardDAO.getInstance();
		
		// �Խñ� ����� SQL�� ����.
			int result = bDao.deleteItem(BoardDB, ItemNum);
			
			if(result==1){
				request.setAttribute("msg","�ش� �Խù� ������ �Ϸ��Ͽ����ϴ�.");
				System.out.println("�Խù� ���� ����");
			}else{
				request.setAttribute("msg","�ش� �Խù� ������ �����Ͽ����ϴ�. �ٽ� �õ��� �ּ���.");
				System.out.println("�Խù� ���� ����");
			}
					
			// �Խ��� ������ jsp ���� jsp include�� �� ������ ���� ������
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
