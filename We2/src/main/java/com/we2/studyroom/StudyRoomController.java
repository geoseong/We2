package com.we2.studyroom;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

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


@Controller
@RequestMapping(value="/studyroom")
public class StudyRoomController {
	
	private static final Logger logger = LoggerFactory.getLogger(StudyRoomController.class);
	@Autowired
    private ServletContext servletContext;
	String path="we2/studyRoom/data";
	@Autowired
	StudyRoomService studyroomService;
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpSession session;
	
	// 페이징처리 싱글톤 인스턴스객체 얻음
	RPagingManager paging = RPagingManager.getInstance();
	
	// 한 페이지에 표시할 레코드 수 정의
	int rows_per_page=9;
	// 한 블럭에 표시할 페이지 수 정의
	int page_for_block=10;
	
	/* 리스트 */
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String listSpecificPageWork(@RequestParam("page") int page, Model model) throws ParseException{
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
			int t_rows = studyroomService.getTotalCnt();
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
		/* SECTION : REQUEST 영역에 보내기 */
		// ★★ SELECT 결과물 ★★
				  model.addAttribute("Content", studyroomService.getlist(row_start, rows_per_page));
				// JSP:INCLUDE PAGE
				  model.addAttribute("studyroompage", "StudyRoomList");
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
		return "studyRoom/shareArea";
	} //end list
	
	/*검색 기능*/
	
	@RequestMapping(value="/search.do", method=RequestMethod.GET)
	public String studyroomsearch(@RequestParam("page") int page, Model model,
			@RequestParam("rlocation") String rlocation,
			@RequestParam("rlocationdetail") String rlocationdetail) throws ParseException{

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
				
			ArrayList<StudyRoomBean> searchbean = new ArrayList<StudyRoomBean>();
			try{
				// 단어검색 select & 페이징 기법 을 ArrayList로 받음
				searchbean = studyroomService.getSearchstudyroom(rlocation, rlocationdetail, row_start, rows_per_page);
				// Exception 발생하나 보기
				searchbean.get(0);
			}catch(IndexOutOfBoundsException e){
				model.addAttribute("msg", "검색결과가 없습니다.");
				return listSpecificPageWork(1, model);
			}
			
			//검색된 row의 totalcnt를 구하기.
			int t_rows = studyroomService.getsearchTotalCnt(rlocation, rlocationdetail);
			
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

		/* SECTION : REQUEST 영역에 보내기 */
		// ★★ SELECT 결과물 ★★
			  model.addAttribute("Content", searchbean);
			// JSP:INCLUDE PAGE
			  model.addAttribute("studyroompage", "StudyRoomFind");
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
		
		return "studyRoom/shareArea";
	} //end search.do



	
	/** 글쓰기 폼 띄우기 */
	@RequestMapping(value="/studyroomwrite.do", method=RequestMethod.GET)
	public String aopwriteget(Model model, StudyRoomBean studyRoomBean){
		System.out.println("---글쓰기 페이지 진입");
		// JSP:INCLUDE PAGE
		  model.addAttribute("studyroompage", "StudyRoomWrite");
	 
		return "studyRoom/StudyRoomWrite";
	}
	
	
	/** 글 등록하기 
	 * @throws ParseException 
	 * @throws IOException */
	
	@RequestMapping(value="/studyroomwrite.do", method=RequestMethod.POST)
	public String writepost(/*HttpServletRequest request, */Model model) throws IOException {
	    System.out.println("studyroomwrite.POST]");
		// 해당 경로의 폴더가 안만들어져있다면 직접 만들어놔야할 것.
		
		// getRealPath : E:\JavaSmartWeb\mywork_web\.metadata\.plugins\org.eclipse.wst.server.core\tmp2\wtpwebapps\testweb\
		String encType="UTF-8";
		int sizeLimit = 20*1024*1024;
		
			System.out.println("multipartrequest적용 전");
		
		MultipartRequest multi = new MultipartRequest(request, servletContext.getRealPath(path), sizeLimit, encType, new DefaultFileRenamePolicy());
		
			System.out.println("multipartrequest적용 후");
		
		//PjtBoardBean객체인 sVo에 변수들을 집어넣는다.
		StudyRoomBean sVo = new StudyRoomBean();
		//1. 글번호는 DAO의 SQL sequence로 내부적으로 처리.
		//2. 제목
			String rname=multi.getParameter("rname");
			sVo.setRname(rname);
				System.out.println("WriteServlet - title : " + sVo.getRname());
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
			studyroomService.insertStudyRoom(sVo.getRname(), sVo.getRlocation(), sVo.getRlocationdetail(), sVo.getRcontent(), sVo.getRmember(),sVo.getRpictureurl());
		
		// JSP:INCLUDE PAGE
		  model.addAttribute("studyroompage", "StudyRoomList");
		  model.addAttribute("page", 1);
		
		return "studyRoom/close";
	}
	
	
		
	/* 삭제하기 */

		@RequestMapping(value="/StudyRoomdelete.do", method=RequestMethod.GET)
		public String StudyRoomdelete(@RequestParam("rcode") int rcode, Model model) throws ParseException {
		
			logger.info("StudyRoomdelete called!!");
			logger.info("rcode=["+rcode+"] ");
			
			// BoardDelete -
			  model.addAttribute("studyroomList", studyroomService.getSearchbyrcode(rcode));	
			  // JSP:INCLUDE PAGE
			  model.addAttribute("studyroompage", "StudyRoomDelete");
			  model.addAttribute("page", 1);
			return "studyRoom/StudyRoomDelete";   
		}
			
		@RequestMapping(value="/StudyRoomdelete.do", method=RequestMethod.POST)
		public String StudyRoomdeletepos(@RequestParam("rcode") int rcode, Model model) {
			
			logger.info("DeleteSpecificRow called!!");
			logger.info("rcode=["+rcode+"] ");
			studyroomService.deleteRow(rcode);
			// JSP:INCLUDE PAGE
			  model.addAttribute("studyroompage", "StudyRoomList");
			  model.addAttribute("page", 1);
			  /*model.addAttribute("shareArea", new Integer(studyroomService.getTotalCnt()));*/
			return "studyRoom/close";   
		}
		
		
		
	/* 수정하기 */
		
		@RequestMapping(value="/StudyRoomupdate.do", method=RequestMethod.GET)
		public String StudyRoomupdate(@RequestParam("rcode") int rcode, Model model) throws ParseException {
		
			logger.info("StudyRoomupdate called!!");
			logger.info("rcode=["+rcode+"] ");			
					
			// Update
			  model.addAttribute("studyroomList", studyroomService.getSearchbyrcode(rcode));	
			  // JSP:INCLUDE PAGE
			  model.addAttribute("studyroompage", "StudyRoomUpdate");
			  model.addAttribute("page", 1);
			return "studyRoom/StudyRoomUpdate";   
		}
			
		@RequestMapping(value="/StudyRoomupdate.do", method=RequestMethod.POST)
		public String StudyRoomupdatepos(StudyRoomBean studyRoomBean, Model model , HttpSession session) throws IOException {
			
			String path=servletContext.getRealPath("we2/studyRoom/data");
			System.out.println("path : "+path);
			// getRealPath : E:\JavaSmartWeb\mywork_web\.metadata\.plugins\org.eclipse.wst.server.core\tmp2\wtpwebapps\testweb\
			String encType="UTF-8";
			int sizeLimit = 20*1024*1024;
			MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
			//2. 제목
			String rname=multi.getParameter("rname");
			studyRoomBean.setRname(rname);
				System.out.println("WriteServlet - rname : " + studyRoomBean.getRname());
		//4. 위치
			String rlocation=multi.getParameter("rlocation");
			studyRoomBean.setRlocation(rlocation);
			System.out.println("WriteServlet - rlocation : " + studyRoomBean.getRlocation());	
		//5. 상세 위치
			String rlocationdetail = multi.getParameter("rlocationdetail");
			studyRoomBean.setRlocationdetail(rlocationdetail);
			System.out.println("WriteServlet - rlocationdetail : " + studyRoomBean.getRlocationdetail());
		//6. 파일경로
				String rpictureurl = null;
				studyRoomBean.setRpictureurl(rpictureurl);
				System.out.println("WriteServlet - rpictureurl : " + studyRoomBean.getRpictureurl());

				
				
		//7. 게시물 내용
			String rcontent=multi.getParameter("rcontent");
			studyRoomBean.setRcontent(rcontent);;
				System.out.println("WriteServlet - rcontent : " + studyRoomBean.getRcontent());
		
		//8. 인원수
			int rmember=Integer.parseInt(multi.getParameter("rmember"));
			studyRoomBean.setRmember(rmember);
			System.out.println("WriteServlet - rmember : " + studyRoomBean.getRmember());
		//9. 코드번호	
			int rcode=Integer.parseInt(multi.getParameter("rcode"));
			studyRoomBean.setRcode(rcode);
			System.out.println("WriteServlet - rcode : " + studyRoomBean.getRcode());
			
			// 파일수정 아무것도 안하면 null값을 받아오는데, 파일이 날라갈 것을 방지하기위한 if문.
			if (multi.getFilesystemName("rpictureurl") != null) {
				rpictureurl = multi.getFilesystemName("rpictureurl");
				System.out.println("자료 업뎃함.");
			} else {
				// BoardMapper에서 select 결과를 받아옴.
				rpictureurl = studyroomService.getSearchbyrcode(rcode).getRpictureurl();
				System.out.println("자료수정된 것 없음");
			} // end if
			
		// 게시글 내용들을 update 하기
		
			logger.info("updateRow called!!");			
			
			studyroomService.updateRow(rcode, rname, rlocation, rlocationdetail, rcontent, rmember, rpictureurl);
			
			// JSP:INCLUDE PAGE
			  //model.addAttribute("shareArea", new Integer(studyroomService.getTotalCnt()));
			  model.addAttribute("studyroompage", "StudyRoomList");
			  model.addAttribute("page", 1);
			  
			return "studyRoom/close";   
		}

		/*내용 보기*/
		@RequestMapping(value="/StudyRoomContent.do", method=RequestMethod.GET)
		public String StudyRoomContent(@RequestParam("rcode") int rcode, Model model) throws ParseException {
		
			logger.info("StudyRoomupdate called!!");
			logger.info("rcode=["+rcode+"] ");			
					
			// Update
			  model.addAttribute("studyroomList", studyroomService.getSearchbyrcode(rcode));	
			  // JSP:INCLUDE PAGE
			  model.addAttribute("studyroompage", "StudyRoomContent");
			  model.addAttribute("page", 1);
			return "studyRoom/StudyRoomContent";   
		}



			
}
