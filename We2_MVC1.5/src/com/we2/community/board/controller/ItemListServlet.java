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
				response.sendRedirect("index.jsp");
			}// end if
			
			System.out.println("���̺�� : " + BoardDB);

			request.setAttribute("page", page);
		/* DB , ������ ���� ���� ��*/
		
		System.out.println("ItemList - page�Ķ���� ���� �� : "+ request.getParameter("page"));
		System.out.println("ItemList - url �� : " + url);	
								
		
	/** ����¡ ���*/
		int pagelink=1;
		int startRcdNo=1;
		
	// pagelink, startRcdNo �Ķ���͸� �޴´�.���� �� ���ٸ�, �� ù������ ���
		if(request.getParameter("pagelink")!=null){
			 pagelink = Integer.parseInt(request.getParameter("pagelink"));
		}else{
			 System.out.println("pagelink �Ķ���ʹ� null�̴�");
		}
		
		if(request.getParameter("startRcdNo")!=null){
			 startRcdNo=Integer.parseInt(request.getParameter("startRcdNo"));
		}else{
			 System.out.println("startRcdNo �Ķ���ʹ� null�̴�");
		}		
		
/** find �Ķ���Ͱ��� ������ Search���. */
		if(request.getParameter("find")!=null){
			System.out.println("�� ItemListServlet = �˻����");
			// �޺��ڽ��� ���� �Ķ���� �޾ƿ���				
			String find=null;				
			String findword=request.getParameter("findword");				
							
			if(request.getParameter("find").equals("itemNum")){				
				find="itemNum";			
			}else if(request.getParameter("find").equals("userId")){				
				find="userId";			
			}else{				
				find="itemContent";			
			}				
							
			System.out.println("find�� : " + find);				
			System.out.println("findword�� : " + findword);				
							
			//SQL���� ���� ���� �ν��Ͻ�ȭ				
			BoardDAO bDao = BoardDAO.getInstance();				
							
			/** ����¡ ��� ���� */				
			// �Խ��� ���̺��� �� ���ڵ尳�� ���ϱ�				
			int totrcds = bDao.countsearchedRecords(BoardDB, find, findword);				
			System.out.println("SearchServlet totrcds : " + totrcds);				
							
			// �������� ������ ���������� ����				
				int rcdsinone = 10;			
							
			// �Ķ���� : �ѷ��ڵ尳�� , �ϴ��� ǥ�õǴ� ����������, �� �������� ������ ���ڵ尳��				
			PagingCount pgcnt = new PagingCount(totrcds, 10, rcdsinone);				
							
			// List result������ �˻����� ����¡����� ������ SQL���� ����� ����				
			// request������ ����� list ����.				
			int endpage = startRcdNo+rcdsinone;				
			List<BoardVO> result = bDao.searchItem(BoardDB, find, findword, startRcdNo, endpage);				
							
			// jsp�� EL������ ���� ���� ����				
			request.setAttribute("BoardList", result);				
							
			// find�� findword�� ������ attribute�� ����.				
			request.setAttribute("find", find);				
			request.setAttribute("findword", findword);				
							
			// �Խ��� ������ jsp ���� jsp include�� �� ������ ���� ������				
			request.setAttribute("Boardpage", "ItemList.jsp");				
							
			// �ϴܿ� ����¡��� �±׸� ���� �޼ҵ�.				
			String pagecounting = pgcnt.showSearchPaging(pagelink, "ItemList", find, findword, page);				
							
			// ����¡��� �±׸� request������ ����				
			request.setAttribute("pagecounting", pagecounting);				
			System.out.println("----------------------ItemListServlet doPost");				
		
		}else{
 /** find �Ķ���Ͱ��� ������ �Ϲ� ����Ʈ �Ѹ��� */
			System.out.println("ItemListServlet = �Ϲ� ����Ʈ���");
			// �������� ������ ���ڵ尳�� ����
			int rcdsinone = 10;
			
			//SQL���� ���� ���� �ν��Ͻ�ȭ
			BoardDAO bDao = BoardDAO.getInstance();	
			
			// �Խ��� ���̺��� �� ���ڵ尳�� ���ϱ�
			int totrcds = bDao.countRecords(BoardDB);
			
			// �Ķ���� : �ѷ��ڵ尳�� , �ϴ��� ǥ�õǴ� ����������, �� �������� ������ ���ڵ尳��
			PagingCount pgcnt = new PagingCount(totrcds, 10, rcdsinone);
			
			// �ϴܿ� ����¡��� �±׸� ���� �޼ҵ�.
			String pagecounting = pgcnt.showPaging(pagelink, "ItemList");
			
			// ȭ�鿡 �Խù����� �ѷ��ֱ� ���� select������.
			int endpage = startRcdNo+rcdsinone;
			List<BoardVO> BoardList = bDao.seeAllItems(BoardDB, startRcdNo, endpage);
			
			
			// request������ "BoardList" �̸����� ���� ����
				request.setAttribute("BoardList", BoardList);
					
			// ����¡��� �±׸� request������ ����
			request.setAttribute("pagecounting", pagecounting);	
			
			// �Խ��� ������ jsp ���� jsp include�� �� ������ ���� ������
			request.setAttribute("Boardpage", "ItemList.jsp");
			
			System.out.println("url : " + url);
			System.out.println("----------------------ItemListServlet doGet");
		} //end �Ϲ� ����Ʈ�Ѹ���
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("BoardC/" + url + ".jsp");
		dispatcher.forward(request, response);
	} //end doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	} //end doPost

}
