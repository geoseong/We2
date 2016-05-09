package com.we2.project.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.we2.project.dao.ProjectDAO;

/**
 * Servlet implementation class FileExport
 */
@WebServlet("/PjtAdd")
public class PjtAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// page forward
		RequestDispatcher dispatcher=request.getRequestDispatcher("Project/PjtAdd.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 새로만드는 프로젝트 이름을 파라미터로 받는다.
			String getname=request.getParameter("pjt");
			
		// 현재 실행중인 프로젝트의 상대경로 설정 - getpath
			String svlPath=getServletContext().getRealPath("./");		
				System.out.println(svlPath);
			
			File getfile = new File(svlPath);
			String getpath = getfile.getParentFile().getParentFile().getParentFile().getParentFile().getParentFile().getParentFile().toString();
				System.out.println(getpath);
			
		// 0. 이름작업
			// 이름 맨앞글자만 대문자로 만드는 작업.
			String pjtfront1=getname.substring(0, 1);
			String initupper=pjtfront1.toUpperCase();
			
			// 이름의 두번째 글자부터 마지막까지만을 정의해서 앞에 변환된 대문자 첫글자와 합침
			String pjtlast=getname.substring(1, getname.length());
			String filename=initupper + pjtlast;
		
		// ★ FileCopyControl에서 객체 인스턴스화
			PjtCtrler fCopy = new PjtCtrler();
			
		// ★ ProjectDAO에서 객체 인스턴스화 - DB접근을 위함.
			ProjectDAO pDao = ProjectDAO.getInstance();
			
		// 1. 프로젝트 파일이름 중복검사
			int result=pDao.checkName(filename);			
			
			if(result==1){
				// 1-1. WebContent 복사. 
				//slc : 원본파일경로, tlc : 복사될파일경로
					File slc=new File(getpath+"/We2/WebContent/Project/We2_page/");
					File tlc=new File(getpath+"/We2/WebContent/Project/" + filename);					
					fCopy.setFileCopy(slc, tlc);
					
				// 1-2. 프로젝트 리스트 DB에 기록하기
				pDao.insertMember(filename);
				request.setAttribute("result", "프로젝트 생성에 성공하였습니다.");
			}else{
				request.setAttribute("result", "이미 존재하는 프로젝트 이름입니다. 다시 시도해 주세요.");
			}
		
		// Tomcat서버 Refresh.
			//2. 톰캣의 빠른 Refresh를 위해 임시방편으로 jar파일을 WEB-INF/lib/ 안에 Copy를 한다. 한 10초 걸리게 설정.	
			// sourcecopy : jar이 존재하는 경로 , sourcepaste : WEB-INF/lib/
			File sourcecopy = new File(getpath+"/We2/WebContent/ojdbc5.jar");
			File sourcepaste = new File(getpath+"/We2/WebContent/WEB-INF/lib/ojdbc5.jar");
			fCopy.setFileCopy(sourcecopy, sourcepaste);
			fCopy.tempDel(sourcepaste); 
		
		// attribute를 들고 jsp페이지로 이동
		RequestDispatcher dispatcher=request.getRequestDispatcher("/Project/PjtAdd.jsp");
		dispatcher.forward(request, response);
	}

}
