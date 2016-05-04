package mysite.com.app;

import javax.jws.WebParam.Mode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BbsController {

	@Autowired		// 서비스 객체 자동 의존주입
	BoardService boardService;
	
	private static final Logger logger = LoggerFactory.getLogger(BbsController.class);
	
	@RequestMapping(value="/show_write_form.do", method=RequestMethod.GET)
	public String show_write_form(Model model){
		logger.info("show_write_form called!!");	// 객체를 전달해서 값을 얻어와야 함!!!
		model.addAttribute("boardBeanObjToWrite", new BoardBean());
		return "board/writeBoard";
	}
	
	@RequestMapping(value="/DoWriteBoard.do", method=RequestMethod.POST)
	public String DoWriteBoard(BoardBean boardBeanObjToWrite, Model model){
		logger.info("DoWriteBoard called!!");
		logger.info("memo=[" + boardBeanObjToWrite.getMemo() + "]");
		boardService.insertBoard(boardBeanObjToWrite);
		model.addAttribute("totalCnt", new Integer(boardService.getTotalCnt()));
		model.addAttribute("current_page", "1");		// 글작성 후에는 처음 페이지로 돌아간다
		model.addAttribute("boardList", boardService.getList(1, 2));
		return "board/listSpecificPage";
	}
	
	// 개별 목록 조회
	@RequestMapping(value="/viewWork.do", method=RequestMethod.GET)
	public String viewWork (
				@RequestParam("memo_id") String memo_id,
				@RequestParam("current_page") String current_page,
				@RequestParam("searchStr") String searchStr,
				Model model
			)
	{
		logger.info("viewWork called!!");
		logger.info("memo_id=[" + memo_id + "] current_page=[" + current_page + "] searchStr=[" + searchStr + "]");
		model.addAttribute("memo_id", memo_id);
		model.addAttribute("current_page", current_page);
		model.addAttribute("searchStr", searchStr);
		model.addAttribute("boardData", boardService.getSpecificRow(memo_id));
		return "board/viewMemo";
	}
	
	// 특정 페이지에서 작업중 목록으로 나올경우, 이전 페이지 번호를 참조해서 해당 페이지 출력
	@RequestMapping(value="/listSpecificPageWork.do", method=RequestMethod.GET)
	public String listSpecificPageWork( @RequestParam("current_page") String pageForView, Model model)
	{
		System.out.println("-------------------------------------------");
		logger.info("listSpecificPageWork called!!");
		logger.info("current_page=[" + pageForView + "]");
		model.addAttribute("totalCnt", new Integer(boardService.getTotalCnt()));
		model.addAttribute("current_page", pageForView);
		model.addAttribute("boardList", boardService.getList(Integer.parseInt(pageForView), 2));
		System.out.println("-------------------------------------------listSpecificPage");
		return "board/listSpecificPage";
	}
	
	// 특정 페이지 수정을 위한 내용 출력
	@RequestMapping(value="/listSpecificPageWork_to_update.do", method=RequestMethod.GET)
	public String listSpecificPageWork_to_update(
				@RequestParam("memo_id") String memo_id,
				@RequestParam("current_page") String current_page,
				Model model
			)
	{
		logger.info("listSpecificPageWork_to_update called!!");
		logger.info("memo_id=[" + memo_id + "] current_page=[" + current_page + "]");
		model.addAttribute("memo_id", memo_id);
		model.addAttribute("current_page", current_page);
		model.addAttribute("boardData", boardService.getSpecificRow(memo_id));
		return "board/viewMemoForUpdate";
	}
	
	// 개별 row 업데이트
	@RequestMapping(value="/DoUpdateBoard.do", method=RequestMethod.POST)
	public String DoUpdateBoard(
				BoardBean boardBoardObjToUpdate,
				@RequestParam("memo_id") int memo_id,	// String, int 둘 다 적용됨
				@RequestParam("current_page") String current_page,
				Model model
			)
	{
		logger.info("DoUpdateBoard called!!");
		logger.info("listSpecificPageWork_to_update called!!");
			// boardBeanObjToUpdate.getId() 가 0이다! 값을 설정하지 않았기 때문이다. 대신, memo_id를 이용하자.
		logger.info("memo_id=[" + memo_id + "" + "/" + boardBoardObjToUpdate.getId() + "current_page=[" + current_page + "]");
		logger.info("memo=[" + boardBoardObjToUpdate.getMemo() + "]");
		boardBoardObjToUpdate.setId(memo_id); 	//약간의 꼼수.(?)
		boardService.updateBoard(boardBoardObjToUpdate);
		model.addAttribute("totalCnt", new Integer(boardService.getTotalCnt()));
		model.addAttribute("current_page", current_page);
		model.addAttribute("boardList", boardService.getList(Integer.parseInt(current_page), 2));
		return "board/listSpecificPage";
	}
	
	// 삭제 DeleteSpecificRow
	@RequestMapping(value="/DeleteSpecificRow.do", method=RequestMethod.GET)
	public String DeleteSpecificRow(
			@RequestParam("memo_id") int memo_id,
			@RequestParam("current_page") String current_page,
			Model model
			)
	{
		logger.info("DeleteSpecificRow called!!");
		logger.info("memo_id=[" + memo_id + "] current_page=[" + current_page + "]");
		boardService.deleteRow(memo_id);
		// 다시 페이지를 조회한다.
		model.addAttribute("totalCnt", new Integer(boardService.getTotalCnt()));
		model.addAttribute("current_page", current_page);
		model.addAttribute("boardList", boardService.getList(Integer.parseInt(current_page), 2));
		return "board/listSpecificPage";
	}
	
	@RequestMapping(value="/searchWithSubject.do", method=RequestMethod.POST)
	public String searchWithSubject(
				@RequestParam("searchStr") String searchStr,
				Model model
			) 
	{
		// redirection...
		return listSearchedSepcificPageWork("1", searchStr, model); 		// 처음에는 1 페이지만 보여줌
	}
	
	// 검색된 상태에서 특정 페이지로 이동하기
	@RequestMapping(value="/listSearchedSepcificPageWork.do", method=RequestMethod.GET)
	public String listSearchedSepcificPageWork(
				@RequestParam("pageForView") String pageForView,
				@RequestParam("searchStr") String searchStr,
				Model model
			)
	{
		logger.info("listSearchedSepcificPageWork called!!");
		logger.info("pageForView=[" + pageForView + "]");
		logger.info("searchStr=[" + searchStr + "]");
		model.addAttribute("totalCnt", new Integer(boardService.getTotalCntBySubject(searchStr)));
		model.addAttribute("searchedList", boardService.getSearchedList(Integer.parseInt(pageForView), 2, searchStr));
		model.addAttribute("pageForView", Integer.parseInt(pageForView));
		model.addAttribute("searchStr", searchStr);
		return "board/listSearchedPage";
	}
	
} //end class
