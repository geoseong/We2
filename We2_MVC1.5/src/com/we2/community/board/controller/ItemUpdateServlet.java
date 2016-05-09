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
		// ȸ�� �α��ο��� �˻�.
		if(session.getAttribute("loginUser")==null){
			response.sendRedirect("/We2/01_main.html");
		}else{
		
			/* �������� , ������� , ȸ������ �������� �ǰ����ϴ� �Ķ����(page)�� �޾Ƽ� �����ϱ�. */
				String url=null;
				String BoardDB = null;		
				
				String page = request.getParameter("page");
					System.out.println("ItemUpdateServlet doGet - page�� : " + page);
					
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

		//1. �۹�ȣ�� �Ķ���ͷ� �޾ƿ´�.
		int ItemNum = Integer.parseInt(request.getParameter("itemNum"));
			System.out.println("ItemUpdateServlet doGet - itemNum : " + ItemNum);
			
		// SQL���� �̿��ϴ� Ŭ������ �ν��Ͻ�ȭ
		BoardDAO bDao = BoardDAO.getInstance();
		// ȭ�鿡 �Խù����� �ѷ��ֱ� ���� select������.
		BoardVO bVo = bDao.seeAllItemsforcontent(BoardDB, ItemNum);
		
		request.setAttribute("BoardUpdate", bVo);
		
		// �Խ��� ������ jsp ���� jsp include�� �� ������ ���� ������
		request.setAttribute("Boardpage", "ItemUpdate.jsp");
		
			System.out.println("(doGet) ItemUpdate url : " + url);
			System.out.println("----------------------ItemUpdateServlet doGet");
		RequestDispatcher dispatcher = request.getRequestDispatcher("BoardC/" + url + ".jsp");
		dispatcher.forward(request, response);
		
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" ------------------ ItemUpdateServlet doPost ����");
		request.setCharacterEncoding("UTF-8");
		
		/* MultiPartRequest */
		ServletContext context=getServletContext();
		String path=context.getRealPath("BoardC/pic");
		System.out.println(path);
		String encType = "UTF-8";
		int sizeLimit = 20 * 1024 * 1024;
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());		
		
		
		/* �������� , ������� , ȸ������ �������� �ǰ����ϴ� �Ķ����(page)�� �޾Ƽ� �����ϱ�. */
			String url=null;
			String BoardDB = null;		
			
			String page = multi.getParameter("page");
				System.out.println("page �Ķ���� : " + page);
				
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
		
		//1. �۹�ȣ�� �Ķ���ͷ� �޾ƿ´�.
			int ItemNum = Integer.parseInt(multi.getParameter("itemNum"));
			
		// SQL���� �̿��ϴ� Ŭ������ �ν��Ͻ�ȭ
		BoardDAO bDao = BoardDAO.getInstance();

		//2. ����
			String ItemTitle=multi.getParameter("itemTitle");
		//3. ����ID�� doGet���� ��ȿ�� �˻������Ƿ� update������ skip.
		//4. �Խù� �ۼ����� ���� ��¥�� ǥ���ϴ� sysdate�� DAO����  ���������� ó��.
		//5. ��ȸ���� update���� skip
		//6. ���ϰ��
			String ItemPath=null;
			BoardVO bVo = new BoardVO();
			// ���ϼ��� �ƹ��͵� ���ϸ� null���� �޾ƿ��µ�, ������ ���� ���� �����ϱ����� if��.
			if(multi.getFilesystemName("itemPath")!=null){
				ItemPath = multi.getFilesystemName("itemPath");
				System.out.println("�ڷ� ������.");
			}else{
				bVo = bDao.seeAllItemsforcontent(BoardDB, ItemNum);
				ItemPath = bVo.getItemPath();
				System.out.println("�ڷ������ �� ����");
			}
		//7. �Խù� ����
			String ItemContent=multi.getParameter("itemContent");
					
			System.out.println("doPost itemNum --"+ItemNum);
			System.out.println("doPost itemTitle --"+ItemTitle);
			System.out.println("doPost itemPath --"+ItemPath);
			System.out.println("doPost itemContent --"+ItemContent);
		// SQL�� ��Ա����� BoardDAO �ν��Ͻ�ȭ
			// �۹�ȣ, ����, �Խù� �ۼ���, ���ϰ��, �Խù� ������ Update Set.
			int result=bDao.updateItem(BoardDB, ItemNum, ItemTitle, ItemPath, ItemContent);
				
			
			if(result==1){
				//�Խù� ��� ���� �޽���
				System.out.println("�Խù� ������Ʈ ����");
			}else{
				//�Խù� ��� ����. �ٽ� �õ��ϼ���
				System.out.println("�Խù� ������Ʈ ����");
			}
			
		// ȭ�鿡 �Խù����� �ѷ��ֱ� ���� select������.
		//BoardVO update = bDao.seeAllItemsforcontent(ItemNum);
		//request.setAttribute("BoardUpdate", update);
		request.setAttribute("msg", "�Խù� ������ �Ϸ�Ǿ����ϴ�.");
				
		
		// �Խ��� ������ jsp ���� jsp include�� �� ������ ���� ������
		request.setAttribute("Boardpage", "ItemList.jsp");
		
			System.out.println("(doPost) ItemUpdate url : " + url);
			System.out.println("----------------------ItemUpdateServlet doPost");

		RequestDispatcher dispatcher = request.getRequestDispatcher("ItemList?page="+page);
		dispatcher.forward(request, response);
	}

}
