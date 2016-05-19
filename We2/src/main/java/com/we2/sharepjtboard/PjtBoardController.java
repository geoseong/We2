package com.we2.sharepjtboard;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.we2.spring.AuthInfo;
import com.we2.utils.MailSend;
import com.we2.utils.MailSend.SMTPAuthenticator;

@Controller
@RequestMapping(value="/pjtBoard")
public class PjtBoardController {
	
	@Autowired
	PjtBoardService boardService;
	@Autowired
    private ServletContext servletContext;
	@Autowired
	HttpServletRequest request;
	
	String path="we2/pjtBoard/data";
	int sizeLimit = 20*1024*1024;
	String encType="UTF-8";
	
	// 페이징처리 싱글톤 인스턴스객체 얻음
	PagingManager paging = PagingManager.getInstance();
	
	// 한 페이지에 표시할 레코드 수 정의
	int rows_per_page=10;
	// 한 화면에 표시할 페이지 수 정의
	int page_for_block=10;
	
	/* 리스트 */
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String listget(@RequestParam("page") int page, String category, Model model) throws ParseException {
		System.out.println("-------------------------------받아온 파라미터");
			System.out.println("rows_per_page : " + rows_per_page);
			System.out.println("page : " + page);
		System.out.println("-------------------------------변수설정 시작");

		if(category.equals("group")){
			category="pGroup";
		}else if(category.equals("exam")){
			category="pTest";
		}else if(category.equals("collabo")){
			category="pWithWork";
		}
		System.out.println("List.GET] category : " + category);
		
			// 시작 rownum 받아오기
			int row_start= paging.getFirstRowInPage(page, rows_per_page);
			System.out.println("row_start : " + row_start);
			
			// 끝 rownum 받아오기
			int row_end=paging.getLastRowInPage(page, rows_per_page);
			System.out.println("row_end : " + row_end);
			
			// 토탈 row, page 구하기
			int t_rows = boardService.getTotalCnt(category);
			if(t_rows==0){
				t_rows=1;
				System.out.println("t_rows가 0이면 jsp의 c:if에서 block_last조건식에 위배되어 1로 설정. -- " + t_rows);
			}
			int t_pages = paging.getTotalPage(t_rows, rows_per_page);
			
			// 블락설정 : 한 화면에 표시될 페이지를 토대로 page세션1(1~10), page세션2(11~20)을 정의
			int block=paging.getPageBlock(page, page_for_block);
			int block_total=paging.getPageBlock(t_pages, page_for_block);
			int block_first=paging.getFirstPageInBlock(block, page_for_block);
			int block_last=paging.getLastPageBlock(block, page_for_block);
			
			System.out.println("t_pages : " + t_pages +" , t_rows : "+t_rows+" , block_total : "+block_total+" , block : "+ block + " , block_first : " + block_first + " , block_last : " + block_last);
			if(block_last>t_pages){
				System.out.println("--block_last가 t_pages보다 크므로 내용이 존재하는 페이지만큼만 block_last를 조절.");
				block_last=t_pages;
			}
		System.out.println("-------------------------------변수설정 끝");
		
		/** SECTION : REQUEST 영역에 보내기 */
		// ★★ SELECT 결과물 ★★
			model.addAttribute("Content", boardService.getformatDate(category, row_start, rows_per_page));
		// JSP:INCLUDE PAGE
		  model.addAttribute("Boardpage", "list");
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
		// category 보냄
		  model.addAttribute("category", category);
		System.out.println("--------------------------listSpecificPage");
		
		return "pjtBoard/boardmain";
	}
	
	/** 글쓰기 폼 띄우기 */
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String aopwriteget(HttpSession session, /*HttpServletRequest request,*/ Model model,String category){
		
		System.out.println("Write.get] category : " + category);
		
		/*if(session.getAttribute("authInfo")==null){
			return "redirect:/";
		}*/
		
		// JSP:INCLUDE PAGE
		  model.addAttribute("Boardpage", "write");
		// category 보냄
		  model.addAttribute("category", category); 
		return "pjtBoard/boardmain";
	}
	
	/** 글 등록하기 
	 * @throws IOException */
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String aopwritepost(HttpSession session, /*HttpServletRequest request, */Model model, String category) throws IOException {
		System.out.println("write.post] category : "+category);
		
		// 해당 경로의 폴더가 안만들어져있다면 직접 만들어놔야할 것.
		// getRealPath : E:\JavaSmartWeb\mywork_web\.metadata\.plugins\org.eclipse.wst.server.core\tmp2\wtpwebapps\testweb\
		MultipartRequest multi = new MultipartRequest(
					request, 	servletContext.getRealPath(path), sizeLimit, encType, new DefaultFileRenamePolicy());
		
		
		//PjtBoardBean객체인 pVo에 변수들을 집어넣는다.
		PjtBoardBean pVo = new PjtBoardBean();
		
		//1. 글번호는 DAO의 SQL sequence로 내부적으로 처리.
		//2. 제목
			pVo.setItemTitle(multi.getParameter("itemTitle"));
				System.out.println("WriteServlet - title : " + pVo.getItemTitle());
		//3. 유저ID는 세션에 떠돌아다니는 (로그인중인) 변수를 getAttribute하면 됨
			AuthInfo mVo = (AuthInfo)session.getAttribute("authInfo");
			pVo.setUserId(mVo.getUserId());
				System.out.println("WriteServlet - userid : " + pVo.getUserId());
		//4. 게시물 작성일은 현재 날짜를 표시하는 sysdate를 DAO에서  내부적으로 처리.
		//5. 조회수는 방문할때 doGet방식 - count하라는 파라미터를 넘길때만 +1 하면 될듯
		//6. 파일경로
			pVo.setItemPath(multi.getFilesystemName("file"));
				System.out.println("WriteServlet - boardpath : " + pVo.getItemPath());
		//7. 게시물 내용
			pVo.setItemContent(multi.getParameter("itemContent"));
				System.out.println("WriteServlet - content : " + pVo.getItemContent());
		//8. 데이터 타입
			pVo.setItemDataType(multi.getContentType("file"));
				System.out.println("파일 contentType : " + pVo.getItemDataType());
		// 게시글 내용들을 Insert하기
			boardService.insertBoard(category, pVo.getItemTitle(), pVo.getUserId(), pVo.getItemPath(), pVo.getItemContent(), pVo.getItemDataType());
		
		// JSP:INCLUDE PAGE
		  model.addAttribute("Boardpage", "list");
		  model.addAttribute("page", 1);
		// category 보냄
		  model.addAttribute("category", category);
		return "redirect:list";
	}
	
	@RequestMapping(value="/content", method=RequestMethod.GET)
	public String contentget(Model model, String category, int itemNum) throws IOException {
		System.out.println("Content.GET] itemNum : "+itemNum);
		System.out.println("Content.GET] category : " + category);
		
		// SQL 사용, 결과를 보냄
		//1. 조회수추가, 2. select_by_num
			boardService.count_plus(category, itemNum);
			model.addAttribute("BoardContent", boardService.select_by_num(category, itemNum));
		// JSP:INCLUDE PAGE
			model.addAttribute("Boardpage", "content");
		// category 보냄
		  model.addAttribute("category", category);
		return "pjtBoard/boardmain";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String aopmodifyget(Model model, String category, int itemNum) throws IOException {
		System.out.println("Modify.GET] category : " + category);
		System.out.println("Modify.GET] itemNum : " + itemNum);
		
		model.addAttribute("BoardUpdate", boardService.select_by_num(category, itemNum));
		
		// JSP:INCLUDE PAGE
		model.addAttribute("Boardpage", "modify");
		// category 보냄
		  model.addAttribute("category", category);
		return "pjtBoard/boardmain";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String aopmodifypost(Model model, String category, int itemNum) throws IOException {
		System.out.println("Modify.POST] itemNum : " + itemNum);
		System.out.println("Modify.POST] category : " + category);
		
		MultipartRequest multi = 
				new MultipartRequest(
						request, 	servletContext.getRealPath(path), sizeLimit, encType, new DefaultFileRenamePolicy());
		System.out.println("contenttype : " + multi.getContentType("file"));
		
			System.out.println("pVo 정의 전");
		//PjtBoardBean객체인 pVo 정의
		PjtBoardBean pVo = new PjtBoardBean();
		
		//1. 글번호를 파라미터로 받아온다.
			System.out.println("ItemNum 정의 전");
		int ItemNum = Integer.parseInt(multi.getParameter("itemNum"));
			System.out.println("ItemNum 정의 후");
		//2. 제목
			String ItemTitle=multi.getParameter("itemTitle");
		//3. 유저ID는
		//4. 게시물 작성일
		//5. 조회수는 update에서 skip
		//6. 파일경로
			String ItemPath=null;
			String ItemDataType=null;
			// 파일수정 아무것도 안하면 null값을 받아오는데, 파일이 날라갈 것을 방지하기위한 if문.
				if(multi.getFilesystemName("itemPath")!=null){
					ItemPath = multi.getFilesystemName("itemPath");
					ItemDataType=multi.getContentType("file");
					System.out.println("자료 업뎃함.");
				}else{
					// BoardMapper에서 select 결과를 받아옴.
					pVo = boardService.select_by_num(category, ItemNum);
					ItemPath = pVo.getItemPath();
					ItemDataType=pVo.getItemDataType();
					System.out.println("자료수정된 것 없음");
				} //end if
		//7. 게시물 내용
			String ItemContent=multi.getParameter("itemContent");
			
			// 디버깅.
			System.out.println("doPost itemNum --"+ItemNum);
			System.out.println("doPost itemTitle --"+ItemTitle);
			System.out.println("doPost itemPath --"+ItemPath);
			System.out.println("doPost itemContent --"+ItemContent);
			System.out.println("doPost itemContent --"+ItemDataType);
			
			// 글번호, 제목, 게시물 작성일, 파일경로, 게시물 내용을 Update Set.
			boardService.updateBoard(category, ItemTitle, ItemPath, ItemContent, ItemDataType);

			// JSP:INCLUDE PAGE
				  model.addAttribute("Boardpage", "list");
				  model.addAttribute("page", 1);
			// category 보냄
				  model.addAttribute("category", category);
				return "redirect:list";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String aopdeletepost(Model model, String category, int itemNum) {
		System.out.println("DELETE.POST] category : " + category);
		System.out.println("DELETE.POST] itemNum : " + itemNum);
		// boardMapper 제거 SQL.
		boardService.deleteBoard(category, itemNum);
		
		// JSP:INCLUDE PAGE
		  model.addAttribute("Boardpage", "list");
		  model.addAttribute("page", 1);
		// category 보냄
		  model.addAttribute("category", category);
		  
		return "redirect:list";
	}

	@RequestMapping(value="/find", method=RequestMethod.GET)
	public String findget(Model model, String category, String find, String findword, int page){
		System.out.println("find.GET] category : " + category);
		
		if(find.equals("itemTitle")){				
			find="itemTitle";			
		}else if(find.equals("userId")){				
			find="userId";			
		}else{				
			find="itemContent";			
		}
		System.out.println("find값 : " + find);				
		System.out.println("findword값 : " + findword);	
		
		System.out.println("find.GET] page : " + page);
		// 시작 rownum 받아오기
			int row_start= paging.getFirstRowInPage(page, rows_per_page);
			System.out.println("row_start : " + row_start);
			
			// 끝 rownum 받아오기
			int row_end=paging.getLastRowInPage(page, rows_per_page);
			System.out.println("row_end : " + row_end);
			
			// SQL : 토탈 row, page 구하기
			int t_rows = boardService.getFindCnt(category, find, findword);
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
		
		/** SECTION : REQUEST 영역에 보내기 */
		// find, findword 보냄
			model.addAttribute("find", find);
			model.addAttribute("findword", findword);
		// ★★ SELECT 결과물 ★★
			model.addAttribute("Content", boardService.findBoard(category, find, findword, row_start, rows_per_page));
		// JSP:INCLUDE PAGE
		  model.addAttribute("Boardpage", "find");
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
		// category 보냄
		  model.addAttribute("category", category);
		System.out.println("--------------------------listSpecificPage");
		return "pjtBoard/boardmain";
	}
	
	
	/** 테스트 영역 */
	@RequestMapping(value="/aoptest", method=RequestMethod.GET)
	public String sessionpjt(Model model, String category) {
		System.out.println("/aoptest executed!!");
		model.addAttribute("page","excelView");
		return "myproject/myproject";
	}
	
	@RequestMapping(value="/aoptestauth", method=RequestMethod.GET)
	public String authpjt(Model model, String category) {
		System.out.println("/aoptestauth executed!!");
		model.addAttribute("page","excelView");
		return "myproject/myproject";
	}
	
	@RequestMapping(value="/mailtest", method=RequestMethod.GET)
	public String pjt(Model model, String category) {
		model.addAttribute("page","../WillWork/WillWork.jsp");
		return "myproject/myproject";
	}
	
	@RequestMapping(value="/jqueryModal", method=RequestMethod.GET)
	public String modal(Model model, String category) {
		model.addAttribute("page","boardmain");
		return "test_modal/jqueryModal";
	}
	
	@RequestMapping("/mailsend")
	public void readfile() throws FileNotFoundException, IOException{
		
		/*ServletContext svpath= getServletContext();*/
		String path=servletContext.getRealPath("we2/mailsend");
		/*
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		
		String context=null;
		List<String> mailcontext = new ArrayList<String>();
		
		while( (context=br.readLine()) != null ){
			mailcontext.add(context);
		}
		
		for(int j=0; j<mailcontext.size(); j++){
			System.out.println(mailcontext.get(j));
		}*/
		MailSend mailsend = new MailSend();
		mailsend.main(path, "imf4@naver.com");
		SMTPAuthenticator smtpauth = new SMTPAuthenticator();
		smtpauth.getPasswordAuthentication();
	}
}
