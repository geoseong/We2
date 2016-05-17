package com.we2.file;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.we2.sharepjtboard.PjtBoardBean;
import com.we2.spring.AuthInfo;


@Controller
@RequestMapping(value="/file")
public class FileController {
	
	private static final Logger logger = LoggerFactory.getLogger(FileController.class);
	@Autowired
    private ServletContext servletContext;
	@Autowired
	FileService fileService;
	@Autowired
	HttpServletRequest request;
	
	// 페이징처리 싱글톤 인스턴스객체 얻음
	RPagingManager paging = RPagingManager.getInstance();
	
	// 한 페이지에 표시할 레코드 수 정의
	int rows_per_page=9;
	// 한 화면에 표시할 페이지 수 정의
	int page_for_block=10;
	
	
	/* 리스트 */
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String listSpecificPageWork(@RequestParam("page")  int page, Model model) throws ParseException{
		System.out.println("-------------------------------받아온 파라미터");
			System.out.println("rows_per_page : " + rows_per_page);
			System.out.println("page : " + page);
		System.out.println("-------------------------------변수설정 시작");
			// 시작 rownum 받아오기
			int row_start=0;
			row_start = paging.getFirstRowInPage(page, rows_per_page);
			System.out.println("row_start : " + row_start);
			
			// 끝 rownum 받아오기
			int row_end=0;
			row_end = paging.getLastRowInPage(page, rows_per_page);
			
			System.out.println("row_end : " + row_end);
			int t_rows = fileService.getTotalCnt();
			int t_pages = paging.getTotalPage(t_rows, rows_per_page);
			
			// 블락설정 : 한 화면에 표시될 페이지를 토대로 page세션1(1~10), page세션2(11~20)을 정의
			int block=paging.getPageBlock(page, page_for_block);
			int block_total=paging.getPageBlock(t_pages, page_for_block);
			int block_first=paging.getFirstPageInBlock(block, page_for_block);
			int block_last=paging.getLastPageBlock(block, page_for_block);
			if(block_last>t_pages){
				System.out.println("--block_last가 t_pages보다 크므로 내용이 존재하는 페이지만큼만 block_last를 조절.");
				block_last=t_pages;
			}
			System.out.println("t_pages : " + t_pages +" , t_rows : "+t_rows+" , block_total : "+block_total+" , block : "+ block + " , block_first : " + block_first + " , block_last : " + block_last);
		System.out.println("-------------------------------변수설정 끝");
		/*//디버깅 : 
			int size=content.size();
			for(int i=0; i < size ; i++){
				System.out.println("get ("+ i +") : "+boardService.getList(row_start, row_end).get(i).getItemDate());
				System.out.println("-------------------end of get(" + i + ")");
			} // 디버깅 끝 
*/	
		/* SECTION : REQUEST 영역에 보내기 */
		// ★★ SELECT 결과물 ★★
					model.addAttribute("Content", fileService.getlist(row_start-1, row_end-1));
				// JSP:INCLUDE PAGE
				  model.addAttribute("filepage", "fileList");
				// total page int 변수를 보냄
				  model.addAttribute("t_pages", t_pages);
				// 현재 페이지 번호를 보냄
				  model.addAttribute("c_page", page);
				// 페이지 블락 보냄
				  model.addAttribute("block", block);
				  model.addAttribute("block_first",block_first);
				  model.addAttribute("block_last",block_last);
				  model.addAttribute("block_total",block_total);
				  model.addAttribute("page_for_block", page_for_block);
			
		System.out.println("--------------------------listSpecificPage");
		
		return "file/FileList";
	}

/*
	
	*//** 글쓰기 폼 띄우기 *//*
	@RequestMapping(value="/filewrite.do", method=RequestMethod.GET)
	public String writeget(HttpSession session, HttpServletRequest request, Model model, FileBean fileBean){
		System.out.println("---글쓰기 페이지 진입");
		if(session.getAttribute("authInfo")!=null){
			System.out.println("로그인 되어있음.");
		}
		System.out.println("로그인 안됨");
		// JSP:INCLUDE PAGE
		  model.addAttribute("filepage", "fileWrite");
	 
		return "file/fileWrite";
	}
	*//** 글 등록하기 
	 * @throws ParseException 
	 * @throws IOException *//*
	
	@RequestMapping(value="/filewrite.do", method=RequestMethod.POST)
	public String writepost(HttpSession session, HttpServletRequest request, Model model, String category) throws IOException {
	    // 해당 경로의 폴더가 안만들어져있다면 직접 만들어놔야할 것.
		String path=servletContext.getRealPath("we2/file/data");
		System.out.println("path : "+path);
		// getRealPath : E:\JavaSmartWeb\mywork_web\.metadata\.plugins\org.eclipse.wst.server.core\tmp2\wtpwebapps\testweb\
		String encType="UTF-8";
		int sizeLimit = 20*1024*1024;
		
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
		
		//PjtBoardBean객체인 sVo에 변수들을 집어넣는다.
		FileBean sVo = new FileBean();
		//1. 글번호는 DAO의 SQL sequence로 내부적으로 처리.
		//2. 제목
			String rname=multi.getParameter("rname");
			sVo.setRname(rname);
				System.out.println("WriteServlet - title : " + sVo.getRname());
		//3. 유저ID는 세션에 떠돌아다니는 (로그인중인) 변수를 getAttribute하면 됨
			AuthInfo mVo = (AuthInfo)session.getAttribute("authInfo");
			sVo.setUserId(mVo.getUserId());
				System.out.println("WriteServlet - userid : " + sVo.getUserId());
		//4. 위치
			String rlocation=multi.getParameter("rlocation");
			sVo.setRlocation(rlocation);
			System.out.println("WriteServlet - title : " + sVo.getRlocation());	
		//5. 상세 위치
			String rlocationdetail = multi.getParameter("rlocationdetail");
			sVo.setRlocationdetail(rlocationdetail);
			System.out.println("WriteServlet - title : " + sVo.getRlocationdetail());
		//6. 파일경로
			String rpictureurl = multi.getFilesystemName("rpictureurl");
			sVo.setRpictureurl(rpictureurl);
				System.out.println("WriteServlet - boardpath : " + sVo.getRpictureurl());
		//7. 게시물 내용
			String rcontent=multi.getParameter("rcontent");
			sVo.setRcontent(rcontent);;
				System.out.println("WriteServlet - content : " + sVo.getRcontent());
		
		//8. 인원수
			int rmember=Integer.parseInt(multi.getParameter("rmember"));
			sVo.setRmember(rmember);
			System.out.println("WriteServlet - title : " + sVo.getRmember());
		// 게시글 내용들을 Insert하기
			fileService.insertfile(sVo);
		
		// JSP:INCLUDE PAGE
		  model.addAttribute("filepage", "fileList");
		  model.addAttribute("page", 1);
		
		return "file/shareArea";
	}*/
	
	
/*		
	 삭제하기 

		@RequestMapping(value="/filedelete.do", method=RequestMethod.GET)
		public String filedelete(@RequestParam("rcode") int rcode, Model model) throws ParseException {
		
			logger.info("filedelete called!!");
			logger.info("rcode=["+rcode+"] ");
			
			// 시작 rownum 받아오기
					
			// BoardDelete -
			  model.addAttribute("fileList", fileService.getSearchbyrcode(rcode));	
			  // JSP:INCLUDE PAGE
			  model.addAttribute("filepage", "fileDelete");
			  model.addAttribute("page", 1);
			return "file/fileDelete";   
		}
			
		@RequestMapping(value="/filedelete.do", method=RequestMethod.POST)
		public String filedeletepos(@RequestParam("rcode") int rcode, Model model) {
			
			
			logger.info("DeleteSpecificRow called!!");
			logger.info("rcode=["+rcode+"] ");
			fileService.deleteRow(rcode);
			//�ٽ� �������� ��ȸ�Ѵ�.
			// BoardDelete - 2) �� ���� �� �ٽ� ����Ʈ�� ���ư���
			model.addAttribute("shareArea", new Integer(fileService.getTotalCnt()));
			// JSP:INCLUDE PAGE
			  model.addAttribute("filepage", "fileList");
			  model.addAttribute("page", 1);
			return "file/shareArea";   
		}
		
		
		
	 수정하기 
		
		@RequestMapping(value="/fileupdate.do", method=RequestMethod.GET)
		public String fileupdate(@RequestParam("rcode") int rcode, Model model) throws ParseException {
		
			logger.info("fileupdate called!!");
			logger.info("rcode=["+rcode+"] ");			
					
			// Update
			  model.addAttribute("fileList", fileService.getSearchbyrcode(rcode));	
			  // JSP:INCLUDE PAGE
			  model.addAttribute("filepage", "fileUpdate");
			  model.addAttribute("page", 1);
			return "file/fileUpdate";   
		}
			
		@RequestMapping(value="/fileupdate.do", method=RequestMethod.POST)
		public String fileupdatepos(FileBean fileBean, Model model , HttpSession session, HttpServletRequest request, int rcode ) throws IOException {
			System.out.println("method.POST] rcode : " + rcode);
			String path=servletContext.getRealPath("we2/file/data");
			System.out.println("path : "+path);
			// getRealPath : E:\JavaSmartWeb\mywork_web\.metadata\.plugins\org.eclipse.wst.server.core\tmp2\wtpwebapps\testweb\
			String encType="UTF-8";
			int sizeLimit = 20*1024*1024;
			MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
			//2. 제목
			String rname=multi.getParameter("rname");
			fileBean.setRname(rname);
				System.out.println("WriteServlet - rname : " + fileBean.getRname());
		//3. 유저ID는 세션에 떠돌아다니는 (로그인중인) 변수를 getAttribute하면 됨
			AuthInfo mVo = (AuthInfo)session.getAttribute("authInfo");
			sVo.setUserId(mVo.getUserId());
				System.out.println("WriteServlet - userid : " + sVo.getUserId());
		//4. 위치
			String rlocation=multi.getParameter("rlocation");
			fileBean.setRlocation(rlocation);
			System.out.println("WriteServlet - rlocation : " + fileBean.getRlocation());	
		//5. 상세 위치
			String rlocationdetail = multi.getParameter("rlocationdetail");
			fileBean.setRlocationdetail(rlocationdetail);
			System.out.println("WriteServlet - rlocationdetail : " + fileBean.getRlocationdetail());
		//6. 파일경로
			String rpictureurl = multi.getFilesystemName("rpictureurl");
			fileBean.setRpictureurl(rpictureurl);
				System.out.println("WriteServlet - rpictureurl : " + fileBean.getRpictureurl());
		//7. 게시물 내용
			String rcontent=multi.getParameter("rcontent");
			fileBean.setRcontent(rcontent);;
				System.out.println("WriteServlet - rcontent : " + fileBean.getRcontent());
		
		//8. 인원수
			int rmember=Integer.parseInt(multi.getParameter("rmember"));
			fileBean.setRmember(rmember);
			System.out.println("WriteServlet - title : " + fileBean.getRmember());
		// 게시글 내용들을 update 하기
		
			
			logger.info("updateRow called!!");			
			
			fileService.updateRow(rcode, rname, rlocation, rlocationdetail, rcontent, rmember, rpictureurl);
			
			  model.addAttribute("shareArea", new Integer(fileService.getTotalCnt()));
			// JSP:INCLUDE PAGE
			  model.addAttribute("filepage", "fileList");
			  model.addAttribute("page", 1);
			  
			return "file/shareArea";   
		}*/
		
}
