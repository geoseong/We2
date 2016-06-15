package com.we2.file;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

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
@RequestMapping(value = "/file")
public class FileController {

	private static final Logger logger = LoggerFactory.getLogger(FileController.class);
	@Autowired
	private ServletContext servletContext;
	String path = "we2/file/data";
	@Autowired
	FileService fileService;
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpSession session;

	// 페이징처리 싱글톤 인스턴스객체 얻음
	RPagingManager paging = RPagingManager.getInstance();
	// 한 페이지에 표시할 레코드 수 정의
	int rows_per_page = 9;
	// 한 화면에 표시할 페이지 수 정의
	int page_for_block = 10;

	/* 리스트 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listSpecificPageWork(@RequestParam("page") int page, Model model) throws ParseException {
		System.out.println("-------------------------------받아온 파라미터");
		System.out.println("rows_per_page : " + rows_per_page);
		System.out.println("page : " + page);
		System.out.println("-------------------------------변수설정 시작");
		// 시작 rownum 받아오기
		int row_start = 0;
		row_start = paging.getFirstRowInPage(page, rows_per_page);
		System.out.println("row_start : " + row_start);

		// 끝 rownum 받아오기
		int row_end = 0;
		row_end = paging.getLastRowInPage(page, rows_per_page);

		// pjtCode 받아내기
				int pjtCode = (Integer)session.getAttribute("pjtCode");
					System.out.println("/file list pjtcode : "+pjtCode);
					
		System.out.println("row_end : " + row_end);
		int t_rows = fileService.getTotalCnt(pjtCode);
		int t_pages = paging.getTotalPage(t_rows, rows_per_page);

		// 블락설정 : 한 화면에 표시될 페이지를 토대로 page세션1(1~10), page세션2(11~20)을 정의
		int block = paging.getPageBlock(page, page_for_block);
			System.out.println("/file list.GET \n └ t_pages : "+t_pages+" / " + "page_for_block : "+page_for_block);
		int block_total = paging.getPageBlock(t_pages, page_for_block);
			if(block_total==0){
				block_total=1;
			}
		int block_first = paging.getFirstPageInBlock(block, page_for_block);
		int block_last = paging.getLastPageBlock(block, page_for_block);
		if (block_last > t_pages) {
			System.out.println("--block_last가 t_pages보다 크므로 내용이 존재하는 페이지만큼만 block_last를 조절.");
			block_last = t_pages;
		}

		System.out.println("/file list.GET \n └ block : "+block+" / " + "block_total : "+block_total);
		/* SECTION : REQUEST 영역에 보내기 */
		// ★★ SELECT 결과물 ★★
		model.addAttribute("fileList", fileService.getlist(row_start, row_end, pjtCode));
		// JSP:INCLUDE PAGE
		model.addAttribute("filepage", "fileList");
		model.addAttribute("page", "../file/FileList");
		// total page int 변수를 보냄
		model.addAttribute("t_pages", t_pages);
		// 현재 페이지 번호를 보냄
		model.addAttribute("c_page", page);
		// 페이지 블락 보냄
		model.addAttribute("block", block);
		model.addAttribute("block_first", block_first);
		model.addAttribute("block_last", block_last);
		model.addAttribute("block_total", block_total);
		model.addAttribute("page_for_block", page_for_block);

		System.out.println("--------------------------listSpecificPage");

		return "myproject/myproject";
	}

	@RequestMapping(value = "/filewrite.do", method = RequestMethod.GET)
	public String writeget(HttpSession session, HttpServletRequest request, Model model) {
		System.out.println("---글쓰기 페이지 진입");
		if (session.getAttribute("authInfo") != null) {
			System.out.println("로그인 되어있음.");
		}else{
			System.out.println("로그인 안됨");
		}
		// JSP:INCLUDE PAGE
		model.addAttribute("filepage", "fileWrite");

		return "file/fileWrite";
	}

	/* 글 등록하기	 */
	@RequestMapping(value = "/filewrite.do", method = RequestMethod.POST)
	public String writepost(HttpSession session, HttpServletRequest request, Model model) throws IOException {
		// 해당 경로의 폴더가 안만들어져있다면 직접 만들어놔야할 것.

		// getRealPath :
		// E:\JavaSmartWeb\mywork_web\.metadata\.plugins\org.eclipse.wst.server.core\tmp2\wtpwebapps\We2\
		String encType = "UTF-8";
		int sizeLimit = 20 * 1024 * 1024;

		MultipartRequest multi = new MultipartRequest(
				request, servletContext.getRealPath(path), sizeLimit, encType,
				new DefaultFileRenamePolicy());

		// PjtBoardBean객체인 fVo에 변수들을 집어넣는다.
		FileBean fVo = new FileBean();
		// 1. 글번호는 DAO의 SQL sequence로 내부적으로 처리.
		// 2. 제목
		String fname = multi.getParameter("fname");
		fVo.setFname(fname);

		// 4. 파일경로
		String fileurl = multi.getFilesystemName("fileurl");
		fVo.setFileurl(fileurl);
		System.out.println("WriteServlet - fileurl : " + fVo.getFileurl());

		// pjtCode 받아내기
		int pjtCode = (Integer)session.getAttribute("pjtCode");
			System.out.println("/file write pjtcode : "+pjtCode);
		
		// 게시글 내용들을 Insert하기
		fileService.insertFile(fVo.getFname(), fVo.getFileurl(), pjtCode);

		// alert 메시지.
		String message = "<script type='text/javascript'>" + "alert('게시물 등록이 완료되었습니다.');" + "opener.location.reload();"
				+ "self.close();" + "</script>";
		model.addAttribute("alert", message);

		// JSP:INCLUDE PAGE
		model.addAttribute("filepage", "fileList");
		model.addAttribute("page", "../file/FileList");

		System.out.println(message);
		return "file/close";
	}

	
	/* 삭제하기 */
	@RequestMapping(value = "/filedelete.do", method = RequestMethod.GET)
	public String filedelete(@RequestParam("fcode") int fcode, Model model) throws ParseException {

		logger.info("filedelete called!!");
		logger.info("fcode=[" + fcode + "] ");

		// 시작 rownum 받아오기

		int pjtCode = (Integer)session.getAttribute("pjtCode");
			System.out.println("/file delete.GET pjtcode : "+pjtCode);
		// BoardDelete -
		model.addAttribute("fileList", fileService.getSearchbyfcode(fcode, pjtCode));
		// JSP:INCLUDE PAGE
		model.addAttribute("filepage", "fileDelete");
		model.addAttribute("page", 1);
		return "file/FileDelete";
	}

	@RequestMapping(value = "/filedelete.do", method = RequestMethod.POST)
	public String filedeletepos(@RequestParam("fcode") int fcode, Model model) {

		logger.info("DeleteSpecificRow called!!");
		logger.info("fcode=[" + fcode + "] ");

		int pjtCode = (Integer)session.getAttribute("pjtCode");
		System.out.println("/file delete.POST pjtcode : "+pjtCode);

		// SQL
		fileService.deleteRow(fcode, pjtCode);
		
		// alert 메시지.
		String message = "<script type='text/javascript'>" + "alert('게시물 삭제가 완료되었습니다.');" + "opener.location.reload();"
				+ "self.close();" + "</script>";
		model.addAttribute("alert", message);

		
		// BoardDelete - 2) 
		model.addAttribute("shareArea", new Integer(fileService.getTotalCnt(pjtCode)));
		// JSP:INCLUDE PAGE
		model.addAttribute("filepage", "fileList");
		model.addAttribute("page", 1);
		return "file/close";
	}

	/* 수정하기 */

	@RequestMapping(value = "/fileupdate.do", method = RequestMethod.GET)
	public String fileupdate(@RequestParam("fcode") int fcode, Model model) throws ParseException {

		logger.info("fileupdate called!!");
		logger.info("fcode=[" + fcode + "] ");

		int pjtCode = (Integer)session.getAttribute("pjtCode");
			System.out.println("/file fileupdate.GET pjtcode : "+pjtCode);
		
		// Update
		model.addAttribute("fileList", fileService.getSearchbyfcode(fcode, pjtCode));
		// JSP:INCLUDE PAGE
		model.addAttribute("filepage", "fileUpdate");
		model.addAttribute("page", 1);
		return "file/FileUpdate";
	}

	@RequestMapping(value = "/fileupdate.do", method = RequestMethod.POST)
	public String fileupdatepos(Model model, HttpSession session, HttpServletRequest request) throws IOException {

		// pjtCode를 세션에서 받아오고
		int pjtCode = (Integer)session.getAttribute("pjtCode");
			System.out.println("/file fileupdate.POST pjtcode : "+pjtCode);

		String path = servletContext.getRealPath("we2/file/data");
		System.out.println("path : " + path);
		// getRealPath :
		// E:\JavaSmartWeb\mywork_web\.metadata\.plugins\org.eclipse.wst.server.core\tmp2\wtpwebapps\testweb\
		String encType = "UTF-8";
		int sizeLimit = 20 * 1024 * 1024;
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());

		FileBean fVo = new FileBean();
		// 2. 제목
		String fname = multi.getParameter("fname");
		fVo.setFname(fname);
		System.out.println("filecontroller - fname : " + fVo.getFname());

		// 4. 코드번호
		int fcode = Integer.parseInt(multi.getParameter("fcode"));
		fVo.setFcode(fcode);
		System.out.println("filecontroller - fcode : " + fVo.getFcode());

		// 5. 파일경로
		String fileurl = null;
		fVo.setFileurl(fileurl);
		System.out.println("WriteServlet - fileurl : " + fVo.getFileurl());

		// 파일수정 아무것도 안하면 null값을 받아오는데, 파일이 날라갈 것을 방지하기위한 if문.
		if (multi.getFilesystemName("fileurl") != null) {
			fileurl = multi.getFilesystemName("fileurl");
			System.out.println("자료 업뎃함.");
		} else {
			// BoardMapper에서 select 결과를 받아옴.
			fVo = fileService.select_by_num(pjtCode, fcode);
			fileurl = fVo.getFileurl();
			System.out.println("자료수정된 것 없음");
		} // end if

		// 게시글 내용들을 update 하기
		// SQL
		fileService.updateRow(fcode, fname, fileurl, pjtCode);
		
		// alert 메시지.
		String message = "<script type='text/javascript'>" + "alert('게시물 수정이 완료되었습니다.');" + "opener.location.reload();"
				+ "self.close();" + "</script>";
		model.addAttribute("alert", message);

		model.addAttribute("shareArea", new Integer(fileService.getTotalCnt(pjtCode)));
		// JSP:INCLUDE PAGE
		model.addAttribute("filepage", "fileList");
		model.addAttribute("page", "../file/FileList");

		return "file/close";
	}

}
