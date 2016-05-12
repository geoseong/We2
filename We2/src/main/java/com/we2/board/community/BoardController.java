package com.we2.board.community;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.we2.board.community.BoardController;
import com.we2.board.community.BoardBean;
import com.we2.board.community.BoardService;

@Controller
//@RequestMapping(value="/testSpringMvc")

public class BoardController {

	@Autowired  // 의존성 자동 주입
	BoardService boardService;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	

	// BoardWritefind - 1) 글쓰기
	@RequestMapping(value = "/show_write_form.do", method=RequestMethod.GET)  // 컨트롤러가 처리할 요청 URL
	public String show_write_form(Model model){
		logger.info("show_write_form called!!");
		//객체를 전달해서 값을 얻어와야 함!!
		model.addAttribute("boardBeanObjToWrite", new BoardBean());
		
		return "communityboard/BoardWritefind";   // 글쓰기 창으로 가기
	}
	
	// BoardWritefind -> BoardListfind 2) 글 작성후 리스트로 돌아가기 
	@RequestMapping(value="/DoWriteBoard.do", method=RequestMethod.POST)
	public String DoWrtieBoard(BoardBean boardBeanObjToWrite, Model model){
		logger.info("DoWriteBoard called!!");
		logger.info("cFindContent=["+boardBeanObjToWrite.getcFindContent()+"]");
		boardService.insertBoard(boardBeanObjToWrite);
		model.addAttribute("totalCnt", new Integer(boardService.getTotalCnt()));
		model.addAttribute("current_page", "1"); // 글을 작성후에는 처음 페이지로 돌아간다
		model.addAttribute("boardList", boardService.getList(1, 2));
		return "communityboard/BoardListfind";  // 글 목록(리스트)로 가기
	}
	
	
	
	// BoardContentfind - 1) 내용 보기
	@RequestMapping(value="/viewWork.do", method=RequestMethod.GET)
	public String viewWork(@RequestParam("cFindContent_cFindNum") String cFindContent_cFindNum, @RequestParam("current_page") String current_page, @RequestParam("searchStr") String searchStr, Model model){
		logger.info("viewWork called!!");
		logger.info("cFindContent_cFindNum=["+cFindContent_cFindNum+"] current_page=["+current_page+"] searchStr=["+searchStr+"]");
		model.addAttribute("cFindContent_cFindNum", cFindContent_cFindNum);
		model.addAttribute("current_page", current_page);
		model.addAttribute("searchStr", searchStr);
		model.addAttribute("boardData", boardService.getSpecificRow(cFindContent_cFindNum));
		return "communityboard/BoardContentfind";
	}
	
	// BoardContentfind -> BoardListfind - 2) 내용 본 후 다시 list로 돌아가기
	@RequestMapping(value="/listSpecificPageWork.do", method=RequestMethod.GET)
	public String listSpecificPageWork(@RequestParam("current_page") String pageForView, Model model){
		System.out.println("-------------------------------");
		logger.info("listSpecificPageWork called!!");
		logger.info("current_page=["+pageForView+"]");
		model.addAttribute("totalCnt", new Integer(boardService.getTotalCnt()));
		model.addAttribute("current_page", pageForView);
		model.addAttribute("boardList", boardService.getList(Integer.parseInt(pageForView), 2));
		System.out.println("--------------------------BoardListfind");
		
		return "communityboard/BoardListfind";
	}
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String test(){
		System.out.println("test");
		return "index";
	}
	
	//특정 페이지 수정을 위한 내용 출력
	// BoardUpdatefind - 1) 글 수정하기
	@RequestMapping(value="/listSpecificPageWork_to_update.do", method=RequestMethod.GET)
	public String listSpecificPageWork_to_update(@RequestParam("cFindContent_cFindNum") String cFindContent_cFindNum, @RequestParam("current_page") String current_page, Model model){
		logger.info("listSpecificPageWork_to_update called!!");
		logger.info("cFindContent_cFindNum=["+cFindContent_cFindNum+"] current_page=["+current_page+"]");
		model.addAttribute("cFindContent_cFindNum", cFindContent_cFindNum);
		model.addAttribute("current_page", current_page);
		model.addAttribute("boardData", boardService.getSpecificRow(cFindContent_cFindNum));
		return "communityboard/BoardUpdatefind";
	}
	
	
	// BoardUpdatefind -> BoardListfind - 2) 글 수정한 후 다시 list로 돌아가기
	//개별 row 업데이트
	@RequestMapping(value="/DoUpdateBoard.do", method=RequestMethod.POST)
	public String DoUpdateBoard(BoardBean boardBeanObjToUpdate, @RequestParam("cFindContent_cFindNum") int cFindContent_cFindNum, @RequestParam("current_page") String current_page, Model model){
		logger.info("DoUpdateBoard called");
		logger.info("listSpecificPageWork_to_update called!!");
		//boardBeanObjToUpdate.getId()가 0이다! 값을 설정하지 않았기 때문이다. 대신 .cFindContent_cFindNum를 이용하자.
		logger.info("cFindContent_cFindNum=["+cFindContent_cFindNum+""+"/"+boardBeanObjToUpdate.getcFindNum()+"] current_page=["+current_page+"]");
		logger.info("cFindContent=["+boardBeanObjToUpdate.getcFindContent()+"]");
		boardBeanObjToUpdate.setcFindNum(cFindContent_cFindNum);//약간의 꼼수
		boardService.updateBoard(boardBeanObjToUpdate);
		model.addAttribute("totalCnt", new Integer(boardService.getTotalCnt()));
		model.addAttribute("current_page", current_page);
		model.addAttribute("boardList", boardService.getList(Integer.parseInt(current_page), 2));
		return "communityboard/BoardListfind";
	}
	
	
	// BoardDeletefind - 1) 글 삭제하기
	// 삭제 DeleteSpecificRow
	@RequestMapping(value="/DeleteSpecificRow.do", method=RequestMethod.GET)
	public String DeleteSpecificRow(@RequestParam("cFindContent_cFindNum") int cFindContent_cFindNum, @RequestParam("current_page") String current_page, Model model){
		logger.info("DeleteSpecificRow called!!");
		logger.info("cFindNum=["+cFindContent_cFindNum+"] current_page=["+current_page+"]");
		boardService.deleteRow(cFindContent_cFindNum);
		//다시 페이지를 조회한다.
		// BoardDeletefind -> BoardListfind - 2) 글 삭제 후 다시 리스트로 돌아가기
		model.addAttribute("totalCnt", new Integer(boardService.getTotalCnt()));
		model.addAttribute("current_page", current_page);
		model.addAttribute("boardList", boardService.getList(Integer.parseInt(current_page), 2));
		return "communityboard/BoardListfind";   
	}
	
	
	// BoardSearch - 1) 글 검색하기 
	@RequestMapping(value="/searchWithSubject.do", method=RequestMethod.POST)
	public String searchWithSubject(@RequestParam("searchStr") String searchStr, Model model){
		//redirection...
		return listSearchedSpecificPageWork("1", searchStr, model);//처음에는 1페이지만 보여줌
	}

	// BoardSearch - 2) 검색한 특정 list로 이동하기  
	// 검색된 상태에서 특정 페이지로 이동하기
	@RequestMapping(value="/listSearchedSpecificPageWork.do", method=RequestMethod.GET)
	public String listSearchedSpecificPageWork(@RequestParam("pageForView") String pageForView, @RequestParam("searchStr") String searchStr, Model model){
		logger.info("listSearchedSpecificPageWork called!!");
		logger.info("pageForView=["+pageForView+"]");
		logger.info("searchStr=["+searchStr+"]");
		model.addAttribute("totalCnt", new Integer(boardService.getTotalCntBySubject(searchStr)));
		model.addAttribute("searchedList", boardService.getSearchedList(Integer.parseInt(pageForView), 2, searchStr));
		model.addAttribute("searchStr", searchStr);
		return "communityboard/BoardListfind";
	}
	
	
}
