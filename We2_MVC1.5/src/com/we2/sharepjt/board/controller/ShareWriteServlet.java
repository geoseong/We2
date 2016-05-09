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
		// ȸ�� �α��ο��� �˻�.
		if(session.getAttribute("loginUser")==null){
			response.sendRedirect("/We2/index.jsp");
		}else{			
			
			/* �������� , ������� , ȸ������ �������� �ǰ����ϴ� �Ķ����(page)�� �޾Ƽ� �����ϱ�. */
			String url=null;
			String BoardDB = null;		
			
			String page = request.getParameter("page");
			
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
						

			System.out.println("ItemWrite : �α��� ���������� doGet���� ItemWrite.");
			// �Խ��� ������ jsp ���� jsp include�� �� ������ ���� ������
			request.setAttribute("Boardpage", "ItemWrite.jsp");
			

				System.out.println("(doGet) ItemWriteServlet url : " + url);
				System.out.println("----------------------ItemWriteServlet doGet");
			RequestDispatcher dispatcher = request.getRequestDispatcher("BoardP/" + url + ".jsp");
			dispatcher.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		/* �������� , ������� , ȸ������ �������� �ǰ����ϴ� �Ķ����(page)�� �޾Ƽ� �����ϱ�. */
		String url=null;
		String BoardDB = null;		
		
		String page = request.getParameter("page");
		
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

		ServletContext context= getServletContext();		
		String path=context.getRealPath("BoardP/pic");
		System.out.println(path);
		// getRealPath 
		// : E:\JavaSmartWeb\mywork_web\.metadata\.plugins\org.eclipse.wst.server.core\tmp2\wtpwebapps\testweb\
		String encType="UTF-8";
		int sizeLimit = 20*1024*1024;
		
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
		
		HttpSession session = request.getSession();
		
		//BoardVo��ü�� pVo�� �������� ����ִ´�.
			BoardVO pVo = new BoardVO();
		//1. �۹�ȣ�� DAO�� SQL sequence�� ���������� ó��.
		//2. ����
			String title=multi.getParameter("title");
			pVo.setItemTitle(title);
				System.out.println("WriteServlet - title : " + pVo.getItemTitle());
		//3. ����ID�� ���ǿ� �����ƴٴϴ� (�α�������) ������ getAttribute�ϸ� ��
			We2_MemberVO mVo = (We2_MemberVO)session.getAttribute("loginUser");
			String userid=mVo.getUserid();
			pVo.setUserId(userid);
				System.out.println("WriteServlet - userid : " + pVo.getUserId());
		//4. �Խù� �ۼ����� ���� ��¥�� ǥ���ϴ� sysdate�� DAO����  ���������� ó��.
		//5. ��ȸ���� �湮�Ҷ� doGet��� - count�϶�� �Ķ���͸� �ѱ涧�� +1 �ϸ� �ɵ�
			// �ϴ� ��ȸ�� 0���� �ʱ�ȭ.
			pVo.setItemClick(0);
				System.out.println("WriteServlet - ��ȸ�� : " + pVo.getItemClick());
		//6. ���ϰ��
			String boardpath = multi.getFilesystemName("path");
			pVo.setItemPath(boardpath);
				System.out.println("WriteServlet - boardpath : " + pVo.getItemPath());
		//7. �Խù� ����
			String content=multi.getParameter("context");
			pVo.setItemContent(content);
				System.out.println("WriteServlet - content : " + pVo.getItemContent());
					
		// SQL�� ��Ա����� BoardDAO �ν��Ͻ�ȭ
		// �Խñ� ������� Insert�ϱ�
			BoardDAO pDao = BoardDAO.getInstance();
			int result=pDao.InsertItem(BoardDB, pVo);
			
			if(result==1){
				//�Խù� ��� ���� �޽���
				System.out.println("�Խù� ��� ����");
				request.setAttribute("msg", "�Խù� ����� �Ϸ�Ǿ����ϴ�.");
			}else{
				//�Խù� ��� ����. �ٽ� �õ��ϼ���
				System.out.println("�Խù� ��� ����");
				request.setAttribute("msg", "�Խù� ��Ͽ� �����Ͽ����ϴ�.");
			}

		// �Խ��� ������ jsp ���� jsp include�� �� ������ ���� ������
		request.setAttribute("Boardpage", "ItemList.jsp");
		

					System.out.println("(doPost) ItemWriteServlet url : " + url);
					System.out.println("----------------------ItemWriteServlet doPost");
		RequestDispatcher dispatcher=request.getRequestDispatcher("ShareList?page="+page);
		dispatcher.forward(request, response);
	}
}